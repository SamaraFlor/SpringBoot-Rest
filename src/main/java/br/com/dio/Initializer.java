package br.com.dio;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.dio.auth.entity.Role;
import br.com.dio.auth.entity.User;
import br.com.dio.auth.service.RoleService;
import br.com.dio.auth.service.UserService;

@Service
public class Initializer {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@PostConstruct
	public void criaUsuariosEPermissoes() {
		Role roleAdmin = new Role();

		roleAdmin.setName("USER");

		roleService.save(roleAdmin);
//dados do login
		User user = new User();
		user.setAtivo(true);
		user.setEmail("samara@samara.com");
		user.setNome("Samara");
		user.setSenha(new BCryptPasswordEncoder().encode("ola1234"));
		user.setUsername("samaraflor");
		user.setRoles(Arrays.asList(roleAdmin));

		userService.save(user);

	}
}
