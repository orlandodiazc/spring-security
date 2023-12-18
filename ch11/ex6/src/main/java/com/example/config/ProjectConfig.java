package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableMethodSecurity(jsr250Enabled = true, securedEnabled = true)
public class ProjectConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        var userManager = new InMemoryUserDetailsManager();
        var user1 = User.withUsername("natalie")
                        .password("12345")
                        .roles("MANAGER")
                        .build();
        var user2 = User.withUsername("emma")
                        .password("12345")
                        .roles("ADMIN")
                        .build();

        userManager.createUser(user1);
        userManager.createUser(user2);
        return userManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
