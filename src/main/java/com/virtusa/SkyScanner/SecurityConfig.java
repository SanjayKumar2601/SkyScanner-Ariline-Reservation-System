// package com.virtusa.SkyScanner;


// import org.springframework.context.annotation.Bean;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled=true,jsr250Enabled=true)
// public class SecurityConfig {
	
// 	@Bean
// 	public BCryptPasswordEncoder passworedEncoder() {
// 		return new BCryptPasswordEncoder();
// 	}
	
// 	@Bean
// 	public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
// 		InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
// 		manager.createUser(User.withUsername("user")
// 				.password(bCryptPasswordEncoder.encode("user"))
// 				.roles("USER").build());				
				
// 		manager.createUser(User.withUsername("admin")
// 				.password(bCryptPasswordEncoder.encode("admin"))
// 				.roles("USER","ADMIN").build());
				
// 		return manager;
// 	}
// 	@Bean
// 	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// 		http
// 		.authorizeRequests()
// 		.antMatchers("/any/**")
// 		.permitAll()
// 		.and()
// 		.authorizeRequests()
// 		.antMatchers("/adminlogin","/addFlights","/adminHome","/displayremoveFlights","/removeFlight","/viewusers","/adminviewflights")
// 		.hasAnyRole("ADMIN")
// 		.antMatchers("/**")
// 		.hasAnyRole("USER","ADMIN")
// 		.anyRequest()
// 		.authenticated()
// 		.and()
// 		.formLogin()
// 		.and()
// 		.csrf()
// 		.disable();
// 		return http.build();
// 	}
// }
