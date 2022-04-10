package com.stevens.liare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.stevens.liare.security.handler.LoginSuccessHandler;
import com.stevens.liare.security.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private LoginSuccessHandler successHandler;	

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder; //el @Bean esta en config

	@Override
	protected void configure(HttpSecurity http) throws Exception {		

		http.authorizeRequests().antMatchers("/","/admin/**","/assets/**","/css/fonts/**","/favicon.ico","/**/*.png","/*.html",				
				"/**/*.html","/**/*.jpg","/**/*.jpeg","/css/**","/js/**","/img/**","/static/**","/locale").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.successHandler(successHandler)
		.loginPage("/login")
		.defaultSuccessUrl("/inicio") 
		.permitAll()
		.and()
		.logout().permitAll()
		.invalidateHttpSession(true)
     	.clearAuthentication(true)
     	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");

	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
}
