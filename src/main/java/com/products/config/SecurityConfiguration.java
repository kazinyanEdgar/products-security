package com.products.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfiguration.class);

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        try {
            auth.inMemoryAuthentication()
                    .withUser("u")
                    .password("u")
                    .roles("USER")
                    .and()
                    .withUser("a")
                    .password("a")
                    .roles("ADMIN");
        } catch (Exception e) {
            LOGGER.error("Error happened in method configure(AuthenticationManagerBuilder auth)", e);
            e.printStackTrace();
        }
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) {
        try {
            http.authorizeRequests()
                    .antMatchers("/products").permitAll()
                    .antMatchers("/products/add").hasRole("ADMIN")
                    .anyRequest().hasAnyRole("USER", "ADMIN")
                    .and().csrf().disable()
                    .formLogin()
                    .and()
                    .exceptionHandling().accessDeniedPage("/403");
        } catch (Exception e) {
            LOGGER.error("Error happened in method configure(HttpSecurity http)", e);
            e.printStackTrace();
        }
    }


}