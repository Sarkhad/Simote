package org.simote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
	@Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http	.authorizeRequests()
        			.antMatchers("/resources/**", "/registration").permitAll()
        			//.anyRequest().authenticated()
        			.and()
    			.formLogin()
    				.defaultSuccessUrl("/", false)
    				.loginProcessingUrl("/")
    				.successForwardUrl("/")
    				.loginPage("/auth")
    				.permitAll()
    				.and()
    			.logout()
    				.logoutSuccessUrl("/")
    				.permitAll()
    				.and()
    			.exceptionHandling()
    				.accessDeniedPage("/error/forbidden");
    }				

    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder( bCryptPasswordEncoder() );
		auth.inMemoryAuthentication().withUser("user@example.com").password("example").roles("ADMIN");
    }

}
