package com.example.config;

import com.example.provider.CustomAuthenticationProvider;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    private final CustomAuthenticationProvider authenticationProvider;

    public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }
    // The custom authentication provider replaces the next commented snippet
    //    @Bean
    //    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    //        http.httpBasic(Customizer.withDefaults());
    //        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
    //        var user = User.withUsername("admin").password("1234").authorities("read").build();
    //        var userDetailsService = new InMemoryUserDetailsManager(user);
    //        http.userDetailsService(userDetailsService);
    //        return http.build();
    //    }
    //
    //    @Bean
    //    PasswordEncoder passwordEncoder() {
    //        return NoOpPasswordEncoder.getInstance();
    //    }

}
