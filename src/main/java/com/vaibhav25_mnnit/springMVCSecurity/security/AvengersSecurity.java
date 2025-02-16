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
                .roles("AVENGER","MANAGER","ADMIN")
                .build();


        UserDetails captain = User.builder()
                .username("captain")
                .password("{noop}captain")
                .roles("AVENGER","MANAGER")
                .build();


        UserDetails thor = User.builder()
                .username("thor")
                .password("{noop}thor")
                .roles("AVENGER")
                .build();

        UserDetails hulk = User.builder()
                .username("hulk")
                .password("{noop}hulk")
                .roles("AVENGER")
                .build();


        UserDetails blackwidow = User.builder()
                .username("blackwidow")
                .password("{noop}blackwidow")
                .roles("AVENGER")
                .build();

        UserDetails hawkeye = User.builder()
                .username("hawkeye")
                .password("{noop}hawkeye")
                .roles("AVENGER")
                .build();
        return new InMemoryUserDetailsManager(ironman,captain,thor,hulk,blackwidow,hawkeye);
    }

    @Bean
    public SecurityFilterChain avengersFilterChain(HttpSecurity http) throws  Exception
    {
        http.authorizeHttpRequests( configurer ->
                    configurer
                            .requestMatchers("/").hasRole("AVENGER")
                            .requestMatchers("/manager/**").hasRole("MANAGER")
                            .requestMatchers("/admin/**").hasRole("ADMIN")
                            .anyRequest().authenticated()
        )

        .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied")
        )

        .formLogin(form->form.loginPage("/customLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
        )
                .logout(logout -> logout.permitAll()
                );

        return http.build();
    }
}
