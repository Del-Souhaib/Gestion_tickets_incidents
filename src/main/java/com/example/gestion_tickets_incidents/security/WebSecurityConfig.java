package com.example.gestion_tickets_incidents.security;

import com.example.gestion_tickets_incidents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    PasswordConfig passwordConfig;

    //    UserDetailsService userDetailsService;
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder);
        return auth;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/js/**", "/css/**", "/flags/**", "/fonts/**", "/images/**", "/plugins/**").permitAll()
                .anyRequest().authenticated().
                and().formLogin().loginPage("/login").defaultSuccessUrl("/")
                .and().rememberMe().and().logout().permitAll().logoutSuccessUrl("/login")
                .and().csrf().disable();
    }

    //    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("js/**","css/**","flags/**","fonts/**","images/**","plugins/**");
//    }
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return passwordConfig.passwordEncoder();
    }
}
