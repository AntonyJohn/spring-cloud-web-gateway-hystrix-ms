package com.antony.employeeservice.security.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;


/**
*
* @author Antony John
*/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityJWTConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Bean
	public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
		return new JwtAuthenticationFilter();
	}

    @Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {    	    	
    	
    	http
    		.cors()
    			.and()
    				.headers()
    			.and()
    				.authorizeRequests()
    				.antMatchers("/login/authenticatejwt").permitAll()
    				.anyRequest().authenticated().and().exceptionHandling()
    				.authenticationEntryPoint(jwtAuthenticationEntryPoint)
    			.and()
    				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    				//.and().csrf().csrfTokenRepository (this.getCsrfTokenRepository());
    			.and().csrf().disable();
    			//.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
					
		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }
    
    private CsrfTokenRepository getCsrfTokenRepository() {
        CookieCsrfTokenRepository tokenRepository = CookieCsrfTokenRepository.withHttpOnlyFalse();
        tokenRepository.setCookiePath("/");
        return tokenRepository;
    }
}
