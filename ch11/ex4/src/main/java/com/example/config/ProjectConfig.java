package com.example.config;

import com.example.security.DocumentsPermissionEvaluator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableMethodSecurity
public class ProjectConfig {

    private final DocumentsPermissionEvaluator evaluator;

    public ProjectConfig(DocumentsPermissionEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    @Bean

    protected MethodSecurityExpressionHandler createExpressionHandler() {
        var expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(evaluator);
        return expressionHandler;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var userManager = new InMemoryUserDetailsManager();
        var user1 = User.withUsername("natalie")
                        .password("12345")
                        .roles("admin")
                        .build();
        var user2 = User.withUsername("emma")
                        .password("12345")
                        .roles("manager")
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
