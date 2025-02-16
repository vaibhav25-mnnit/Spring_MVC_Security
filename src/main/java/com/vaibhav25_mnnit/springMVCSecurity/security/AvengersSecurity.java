package com.vaibhav25_mnnit.springMVCSecurity.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AvengersSecurity {

    @Bean
    public InMemoryUserDetailsManager avengerDetailManger() {

        UserDetails ironman = User.builder()
                .username("ironman")
                .password("{noop}ironman")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();


        UserDetails captain = User.builder()
                .username("captain")
                .password("{noop}captain")
                .roles("EMPLOYEE","MANAGER")
                .build();


        UserDetails thor = User.builder()
                .username("thor")
                .password("{noop}thor")
                .roles("EMPLOYEE")
                .build();

        UserDetails hulk = User.builder()
                .username("hulk")
                .password("{noop}hulk")
                .roles("EMPLOYEE")
                .build();


        UserDetails blackwidow = User.builder()
                .username("blackwidow")
                .password("{noop}blackwidow")
                .roles("EMPLOYEE")
                .build();

        UserDetails hawkeye = User.builder()
                .username("hawkeye")
                .password("{noop}hawkeye")
                .roles("EMPLOYEE")
                .build();
        return new InMemoryUserDetailsManager(ironman,captain,thor,hulk,blackwidow,hawkeye);
    }

    @Bean
    public SecurityFilterChain avengersFilterChain(HttpSecurity http) throws  Exception
    {
        http.authorizeHttpRequests(configurer -> configurer.anyRequest().authenticated()
        )
                .formLogin(form->form.loginPage("/customLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll());

        return http.build();
    }
}
