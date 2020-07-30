package com.cts.inventorypurchase.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests().antMatchers("/inventory/**","/inventory").permitAll()
		.antMatchers("/addPurchases","/addPurchase","/fidAllPurchase","/findPurchase","/updatePurchase/**","*/deletePurchase/***").permitAll();
		/*	.hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().httpBasic();*/
		
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
		
		auth.inMemoryAuthentication()
		.withUser("admin").password(passwordEncoder().encode("password")).roles("ADMIN")
		.and()
		.withUser("user").password(passwordEncoder().encode("password")).roles("USER");
		
	}

}
