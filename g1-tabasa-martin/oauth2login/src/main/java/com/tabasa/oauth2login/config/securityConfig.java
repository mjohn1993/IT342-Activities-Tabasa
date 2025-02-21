package com.tabasa.oauth2login.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
@EnableWebSecurity
public class securityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
                .oauth2Login(oauth2 -> oauth2.defaultSuccessUrl("http://localhost:8080/user-info", true))
                .logout(logout -> logout.logoutSuccessUrl("/"))
                .build();
    }
}

 
