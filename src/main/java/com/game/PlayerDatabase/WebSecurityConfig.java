package com.game.PlayerDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.game.PlayerDatabase.service.UserDetailServiceImpl;


@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
	
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	private static final AntPathRequestMatcher[] WHITE_LIST_URLS = {
            new AntPathRequestMatcher("/api/**"),
            new AntPathRequestMatcher("/h2-console/**"),
            new AntPathRequestMatcher("/playerlist/**"),
            new AntPathRequestMatcher("/serverlist/**"),
            new AntPathRequestMatcher("/servercomputerlist/**"),
    };
	
	private static final AntPathRequestMatcher[] ADMIN_LIST_URLS = {
            new AntPathRequestMatcher("/admin/**"),
    };
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	    
	    http.authorizeHttpRequests().requestMatchers(ADMIN_LIST_URLS).hasAuthority("ADMIN")
	        .and()
	        .authorizeHttpRequests().requestMatchers(WHITE_LIST_URLS).permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .formLogin()
	        .defaultSuccessUrl("/index", true)
	        .and()
	        .logout()
	        .permitAll()
	        .and()
	        .headers()
	        .frameOptions().disable()
	        .and()
	        .cors()
	        .and()
	        .csrf()
	        .disable()
	        .exceptionHandling()
	        .accessDeniedPage("/403");

	    return http.build();

	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
