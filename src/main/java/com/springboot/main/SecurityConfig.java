package com.springboot.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.main.service.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/user/login").authenticated()
        .antMatchers(HttpMethod.GET, "/bills/getall").authenticated()
        .antMatchers(HttpMethod.GET, "/notices/getallNotices").permitAll()
        .antMatchers(HttpMethod.GET, "/events/getallEvents").permitAll()
        .antMatchers(HttpMethod.POST, "/addcourier/{residentId}").hasAnyAuthority("GATEKEEPER")
        .anyRequest().permitAll()
        .and()
        .httpBasic()
        .and()
        .cors().disable()
        .csrf().disable();
	}

	public DaoAuthenticationProvider getProvider() {
	    DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
	    dao.setPasswordEncoder(getEncoder());
	    dao.setUserDetailsService(userService);
	    return dao;
	}


	@Bean
	public PasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}

}