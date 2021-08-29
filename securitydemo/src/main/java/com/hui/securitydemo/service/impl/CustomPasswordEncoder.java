package com.hui.securitydemo.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author jiehui.huang
 * @version 1.0
 * @date 2021/8/15 23:25
 */
public class CustomPasswordEncoder extends BCryptPasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
