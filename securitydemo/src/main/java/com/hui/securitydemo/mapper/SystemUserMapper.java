package com.hui.securitydemo.mapper;

import com.hui.securitydemo.entity.SystemUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * SystemUser登录认证的mapper文件
 * @author huangjiehui
 */
@Repository
public interface SystemUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);

    SystemUser selectOne(@Param(value = "userName") String userName);
}