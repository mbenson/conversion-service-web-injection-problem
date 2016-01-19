# conversion-service-web-injection-problem
illustrates Spring Boot issue

Basically I've got a project that depends on spring-boot-starter-web and injects the ConversionService into a BeanPostProcessor @Bean, which causes the whole app to fail to start up due to the ServletContext not being injected into the WebMvcAutoConfiguration$EnableWebMvcConfiguration. I believe this is because the EmbeddedWebApplicationContext explicitly ignores the ServletContextAware interface. 
