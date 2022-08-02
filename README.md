# SpringBoot-Rest

Aula Springboot experience


Conceitos

Parte 1 

A sigla REST, em português, significa “Transferência de Estado Representacional”. 
Concebido como uma abstração da arquitetura da web, trata-se de um conjunto de princípios e definições necessários 
para a criação de um projeto com interfaces bem definidas

O que é sistema REST?
REST, ou Representational State Transfer,
é um estilo arquitetônico aplicado para fornecer padrões entre sistemas de computador na web, 
facilitando a comunicação entre eles.

O termo REST significa Representational State Transfer. Nada mais é que um padrão de arquitetura para criar serviços e disponibilizá-los na Web. 
Um serviço RESTful é simplesmente aquele que realiza a implementação deste padrão. Ou seja, não há diferenças.


Parte 2

Primeiramente o Spring Security é um framework do projeto Spring que possui um sistema de autenticação 
e autorização de alto nível e altamente customizável para aplicações Java. A framework inclusive é a solução oficial para 
implementação de recursos de segurança em aplicações Spring Boot, porém ele também pode ser utilizado em conjunto com outras frameworks.

Funcionalidades do Spring Security
Ainda que o foco do Spring Security seja o sistema de autenticação e autorização, ele possui outras funcionalidades que aumentam a 
segurança de nossas aplicações Java, aqui vai uma lista de algumas de suas principais funcionalidades:

Sistema de autenticação
Sistema de autorização
Proteção contra ataques como session fixation, clickjacking e cross site request forgery
Integração com a Servlet API
Integração opcional com o Spring Web MVC
Fácil instalação através de um starter Spring Boot

 Spring Security JWT, ou JSON Web Tokens (RFC 7519 - texto em inglês), é um padrão que, em grande parte, é usado para a segurança em APIs REST. 

Parte 3 
Para que serve o actuator?
O actuator é usado principalmente para expor informações operacionais sobre a aplicação em execução.
Ele usa endpoints HTTP ou beans JMX para nos permitir interagir com ele. Uma vez que essa dependência está no classPath da aplicação, 
vários endpoints ficam disponíveis para nós imediatamente

A funcionalidade Health Checks possibilita testes automatizados através de chamados a recursos de APIs. 
Através de um health check é possível verificar o conteúdo de requisições e respostas para checar se um determinado 
recurso HTTP está funcionando corretamente.

Como usar Health Check?
Adicionando o Health Check na aplicação

UseHealthChecks("/status"); //... } Agora, ao executar a aplicação e acessar a URL /status será exibido se ela está saudável ou não: 
Como está sendo testado apenas se ela responde a uma requisição, a aplicação é considerada saudável.

Parte 4 
São testes que verificam se uma parte específica do código, costumeiramente a nível de função, está funcionando corretamente. 
Em um ambiente orientado a objetos é usualmente a nível de classes e a mínima unidade de testes inclui construtores e destrutores.


MvcMock
Para efetuar o teste de uma aplicação Spring Boot com REST API temos dois métodos:
Inside-server test: Standalone-mode: usar MockMVC sem contexto. Spring context: usar MockMVC gerenciado pelo Spring.
Outside-server test. SpringBootTest com mock: usar MockMVC. Integration test: usar RestTemplate ou TestRestTemplate.

O que é mock MVC?
O método mockMvc. perform() retorna um objeto ResultAction. Isso parece ser um “wrapper” para o MvcResult atual. 
O ResultsActions é um conveniente objeto usado para assegurar o resultado do teste, da mesma forma que os métodos assertEquals(…) 
do JUnit ou verify(…) do Mockito.
