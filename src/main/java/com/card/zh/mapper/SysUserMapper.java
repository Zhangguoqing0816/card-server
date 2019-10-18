package com.card.zh.mapper;

import com.card.zh.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {

    public List<SysUser> selectSysUsers(SysUser user);
    public SysUser selectSysUserByName(String userName);
    public SysUser selectSysUserById(String id);
    public List<SysUser> selectUserRoleAndMenu(SysUser user);
    public SysUser selectUserRoleAndMenuByUserName(String userName);




}
