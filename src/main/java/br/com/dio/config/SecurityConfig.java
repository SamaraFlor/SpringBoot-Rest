package br.com.dio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.dio.auth.service.UserService;
import br.com.dio.config.jwt.JwtAuthenticationEntryPoint;
import br.com.dio.config.jwt.JwtRequestFilter;

@Configuration
@EnableWebSecurity
//WebSecurityConfigurerAdapter -> adpta a segurança da aplicação, @EnableWebSecurity habilita
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserService userService;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	//criptografia da senha
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
 // csrf um tipo de ataque que ja estamos desabilitando
		httpSecurity.csrf().disable()
		// qualquer requisição devera estar autenticado
		//todos conseguem mandar a requisição mesmo sem logar
				.authorizeRequests().antMatchers("/auth/signin").permitAll()
				.antMatchers("/actuator/**").permitAll()
				//tem que ser admin
				.antMatchers("/produto/**").hasAnyRole("ADMIN")
				//tem que estar autenticada
				.antMatchers("/pedido/**").authenticated()
				//qualquer requisição tem que estar autorizada
				.anyRequest().authenticated().and()
				.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}


}