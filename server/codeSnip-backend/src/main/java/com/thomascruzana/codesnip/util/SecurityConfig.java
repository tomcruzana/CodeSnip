package com.thomascruzana.codesnip.util;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

/* NOTE: DO NOT AUTO FORMAT CODE! */

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		// CORS configuration
		// CSRF configuration
		// route security w/ role configurations
		http.cors().configurationSource(new CorsConfigurationSource() {

			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config = new CorsConfiguration();
				config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setAllowCredentials(true);
				config.setAllowedHeaders(Collections.singletonList("*"));
				config.setMaxAge(3600L);
				return config;
			}

		}).and().csrf().ignoringAntMatchers("/register", "/snippetcollection/**","/snippet/**")
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and().authorizeRequests()
				.antMatchers("/snippetcollection/**").hasAnyRole(Role.FREE_USER.name(), Role.PRO_USER.name())
				.antMatchers("/snippet/**").hasAnyRole(Role.FREE_USER.name(), Role.PRO_USER.name())
				.antMatchers("/profile").hasAnyRole(Role.FREE_USER.name(), Role.PRO_USER.name())
				.antMatchers("/tags").hasAnyRole(Role.FREE_USER.name(), Role.PRO_USER.name())
				.antMatchers("/shared").hasRole(Role.PRO_USER.name())
				.antMatchers("/settings").hasAnyRole(Role.FREE_USER.name(), Role.PRO_USER.name())
				.antMatchers("/user").authenticated()
				.antMatchers("/home", "/documentation", "/pricing", "/register", "/share", "/login").permitAll()
				.and().httpBasic()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		return http.build();
	}

	// bcrypt encoder
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}