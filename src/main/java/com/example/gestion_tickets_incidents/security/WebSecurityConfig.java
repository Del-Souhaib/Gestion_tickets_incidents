package com.example.gestion_tickets_incidents.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.gestion_tickets_incidents.security.PasswordConfig.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.gestion_tickets_incidents.security.ApplicationRoles.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated();
        http.formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/succeslogin", true);
        http.csrf().disable();
        http.rememberMe().and();
//        http.csrf().ignoringAntMatchers("/api/**");
    }


    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.builder()
                        .username("user")
                        .password(passwordEncoder.encode("123456"))
                        .roles(ADMIN.name())
                        .build();

        UserDetails user2 =
                User.builder()
                        .username("user2")
                        .password(passwordEncoder.encode("123456"))
                        .roles(DEVELOPER.name())
                        .build();

        UserDetails user3 =
                User.builder()
                        .username("user3")
                        .password(passwordEncoder.encode("123456"))
                        .roles(CLIENT.name())
                        .build();
        return new InMemoryUserDetailsManager(user, user2, user3);
    }


}
