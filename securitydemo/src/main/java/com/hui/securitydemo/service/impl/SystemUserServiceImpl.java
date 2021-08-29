package com.hui.securitydemo.service.impl;

import com.hui.securitydemo.config.SecurityConfig2;
import com.hui.securitydemo.entity.SystemUser;
import com.hui.securitydemo.mapper.SystemUserMapper;
import com.hui.securitydemo.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author jiehui.huang
 * @version 1.0
 * @date 2021/8/14 13:33
 */
@Service
public class SystemUserServiceImpl implements ISystemUserService, UserDetailsService {

    private SystemUserMapper systemUserMapper;

    @Autowired
    public void setSystemUserMapper(SystemUserMapper systemUserMapper) {
        this.systemUserMapper = systemUserMapper;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final SystemUser systemUser = systemUserMapper.selectOne(username);
        // 如果从数据库查询为空，则认证失败
        if (null == systemUser) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("role");

        // 从数据库返回SystemUser对象，得到用户名和密码
        return new User(systemUser.getUserName(),
                new CustomPasswordEncoder().encode(systemUser.getPassword()),
                auth);
        // 还需要在启动类上添加一个注解@MapperScan 启动才能找到mapper

        /**
         * 之前一直报这个错:java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
         * 这个错误表示SpringSecurity没有找到对应的密码解析器来对传过来的明文密码进行解析
         * 原来是如果要自定义用户认证的逻辑，SpringSecurity要求在容器中必须要有PasswordEncoder对象实例，所以通过新增 配置类
         *SecurityConfig2，向容器注册一个PasswordEncoder
         * 的实例对象就不会报错了
         */

    }
}
