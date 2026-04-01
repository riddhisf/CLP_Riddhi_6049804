package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.MyUserDetailsService;

@SpringBootApplication
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityApplication {
	@Autowired
	MyUserDetailsService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
	
	@Bean
	public SecurityFilterChain webSecurityFilter(HttpSecurity http) {
		return http
			    .csrf(csrf->csrf.disable())		//For REST API
				.authorizeHttpRequests(auth->auth
						.requestMatchers("/publicEndPoint","/user").permitAll()
						.anyRequest().authenticated())
				.authenticationProvider(getAuthenticationProvider())
				.httpBasic(Customizer.withDefaults())
				.build();
	}

	private DaoAuthenticationProvider getAuthenticationProvider() {
		// TODO Auto-generated method stub
		DaoAuthenticationProvider dao=new DaoAuthenticationProvider(service);
		dao.setPasswordEncoder(new BCryptPasswordEncoder());
		return dao;
	}

}
