/**
 * 
 */
package com.fci.BlogApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.fci.BlogApp.Security.CustomUserDetailService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rajan.kumar
 *5:46:25 am
 *2023
 *BlogApp
 *TODO
 */
@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
		@Autowired
		private CustomUserDetailService customUserDetailService;
		
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	        .csrf().disable()
	        .authorizeHttpRequests()
	        .anyRequest().authenticated()
	        .and()
	        .httpBasic();
			return http.build();
	    }
	    
//	    @Bean
	    protected void configure(AuthenticationManagerBuilder auth)
	    {
	    	try {
				auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
				e.printStackTrace();
			}
	    }
	    @Bean
	    public PasswordEncoder passwordEncoder()
	    {
			return new BCryptPasswordEncoder();
	    }
	    
	}