package com.example.Bookstore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;





import com.example.Bookstore.web.UserDetailServiceImpl;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailsService;	

	 @Override
	 protected void configure(HttpSecurity  http) throws Exception {
		 http
		 	//CSS enabled without login
		 	.authorizeRequests().antMatchers("/css/**").permitAll()
		 	.and()
		 	.authorizeRequests()
		 		//paths who don't need login
		 		.antMatchers("/","/booklist","/api**","/books").permitAll()
		 		.antMatchers("/admin**").hasRole("ADMIN")
			 		.anyRequest().authenticated()
			 		.and()
		 	.formLogin()
		 		.loginPage("/login")
		 		.defaultSuccessUrl("/booklist")
		 		//everyone can see it 
		 		.permitAll()
		 		.and()
		 	.logout()
		 		.permitAll();
	 }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}