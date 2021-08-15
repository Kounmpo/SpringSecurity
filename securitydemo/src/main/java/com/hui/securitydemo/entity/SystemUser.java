package com.hui.securitydemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiehui.huang
 * @version 1.0
 * @date 2021/8/14 11:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser {
    private Long userId;
    private String userCode;
    private String userName;
    private String password;
    private String fullName;
    private String mobile;
    private Boolean disabled;
}
