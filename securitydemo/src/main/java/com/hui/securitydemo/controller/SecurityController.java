package com.hui.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiehui.huang
 * @version 1.0
 * @date 2021/7/28 23:32
 */
@RestController
@RequestMapping("/test")
public class SecurityController {

    /**
     * SpringSecurity本质上是一个过滤器链 todo 学习过滤器
     * 重点看三个过滤连
     * FilterSecurityInterceptor:是一个方法级的权限过滤器，基本位于过滤链的最底部
     *
     * @return String
     */
    @GetMapping("/hello")
    public String add() {
        return "Hello Security!";
    }


    @GetMapping("/index")
    public String index() {
        return "Hello Index";
    }
}
