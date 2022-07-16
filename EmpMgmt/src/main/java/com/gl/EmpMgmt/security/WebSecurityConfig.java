package com.gl.EmpMgmt.security;

import com.gl.EmpMgmt.service.UserServicesImpl;
import com.gl.EmpMgmt.service.UserServices;
import com.gl.EmpMgmt.entity.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
     @Override
    	protected void configure(HttpSecurity http) throws Exception {
    		http.authorizeRequests()
    		.antMatchers("/").permitAll().and().authorizeRequests().antMatchers("/console/*").permitAll();
    		
    		http.csrf().disable();
            http.headers().frameOptions().disable();
    		
    	}
     @Autowired
     public void configureGlobal(AuthenticationManagerBuilder auth)
             throws Exception
     {
         auth.inMemoryAuthentication()
         	.withUser("admin")
         	.password("password")
         	.roles("ADMIN");
     }

}
