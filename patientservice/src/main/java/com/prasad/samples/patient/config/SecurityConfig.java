package com.prasad.samples.patient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET,
                "/v2/api-docs",
                "/swagger-ui/**",
                "/swagger-resources/**",
                "/webjars/**",
                "favicon.ico")
        .permitAll().anyRequest().authenticated().and().oauth2ResourceServer().jwt();

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
