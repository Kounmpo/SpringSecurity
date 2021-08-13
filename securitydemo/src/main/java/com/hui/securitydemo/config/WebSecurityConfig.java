package com.hui.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author jiehui.huang
 * @version 1.0
 * @date 2021/7/29 0:57
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("hjh02");
        String password2 = passwordEncoder.encode("hjh03");
        auth.inMemoryAuthentication()
                .withUser("hjh02")
                .password(password)
                .roles("admin")
                .and()
                .withUser("hjh03")
                .password(password2)
                .roles("root");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }
}
