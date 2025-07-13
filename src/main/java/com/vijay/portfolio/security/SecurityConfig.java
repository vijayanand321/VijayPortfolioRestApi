package com.vijay.portfolio.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Value("${app.api.username}")
    private String username;

    @Value("${app.api.password}")
    private String password;

	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity httpSecurity) throws Exception {

		return httpSecurity
				.csrf().disable().cors().and().authorizeRequests(authorizeRequests -> authorizeRequests
						.requestMatchers("/images/**","/data/**","/auth").permitAll().anyRequest().authenticated())
				.httpBasic().and().build();
	}

	@Bean
	public UserDetailsService userDetails() {
		UserDetails user = User.withUsername(username).password(passwordEncoder().encode(password)).build();

		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
