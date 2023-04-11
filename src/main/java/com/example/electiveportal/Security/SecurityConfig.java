package com.example.electiveportal.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // UserDetails superUser = User.withUsername("admin")
        // .password(passwordEncoder().encode("password"))
        // .roles("SUPER_ADMIN")
        // .build();
        //
        // UserDetails adminUser = User.withUsername("Mohendra Roy")
        // .password(passwordEncoder().encode("password"))
        // .roles("ADMIN")
        // .build();
        //
        // return new InMemoryUserDetailsManager(superUser, adminUser);
        return new CustomUserDetailsService();
    }

    // @Bean
    // public UserDetailsService fromDataBase() {
    // return new CustomUserDetailsService();
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/home", "/", "/assets/**", "/error")
                .permitAll()
                .requestMatchers("/choice-filling", "/upload")
                .authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/home", true);

        return http.build();
    }

}
