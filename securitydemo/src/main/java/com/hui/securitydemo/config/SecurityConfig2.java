package com.hui.securitydemo.config;

import com.hui.securitydemo.service.impl.CustomPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author jiehui.huang
 * @version 1.0
 * @date 2021/8/29 2:32
 */
@Configuration
public class SecurityConfig2 {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new CustomPasswordEncoder();
    }
}
