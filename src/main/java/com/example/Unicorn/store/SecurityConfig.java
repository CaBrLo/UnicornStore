package com.example.Unicorn.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
CustomerRepo customerRepo;
@Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/unicorns").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/style.css").permitAll()
                // images/**
                //.antMatchers( "/unicorn/{id}").permitAll()
                .antMatchers( "/unicorn").permitAll()
                .antMatchers("/cart").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/profile", "/cart").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/unicorns", true)
                .loginPage("/login")
                .permitAll();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        for (Customer user: customerRepo.getCustomers()){
            manager.createUser(User.withDefaultPasswordEncoder().username(user.getUsername()).password(user.getPassword()).roles("USER").build());
        }

       // manager.createUser(User.withDefaultPasswordEncoder().username("user").password("123").roles("USER").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("123").roles("ADMIN").build());
        return manager;
    }
}



