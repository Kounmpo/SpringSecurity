package com.hui.securitydemo.service.impl;

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
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final SystemUser systemUser = systemUserMapper.selectOne(userName);
        // 如果从数据库查询为空，则认证失败
        if (null == systemUser) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("role");

        // 从数据库返回SystemUser对象，得到用户名和密码
        return new User(systemUser.getUserName(),
                new BCryptPasswordEncoder().encode(systemUser.getPassword()), auth);
        // 还需要在启动类上添加一个注解@MapperScan 启动才能找到mapper
        
    }
}
