package com.Prograd.Springboot.Backend.Config;

import com.Prograd.Springboot.Backend.Security.StudentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private StudentDetailService studentDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {        // basic authentication
        http.csrf().disable().authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
    }

    // tell config to authentication with database

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(this.studentDetailService).passwordEncoder(passwordEncoder());
    }


}
