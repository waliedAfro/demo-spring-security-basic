package com.afro.security.config;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	

	@Autowired
	private UserDetailsService userDetailsService ;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/add").permitAll()
		.antMatchers("/update").hasAuthority("admin")
		.antMatchers("/show").hasAnyAuthority("user","admin")
		.anyRequest()
		.authenticated()
		//.and().httpBasic();
		.and().formLogin();
		
	}
	
	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder  getPasswordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
		
	}

}
