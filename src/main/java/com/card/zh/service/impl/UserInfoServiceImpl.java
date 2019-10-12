package com.card.zh.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.card.zh.entity.UserInfo;
import com.card.zh.mapper.UserInfoMapper;
import com.card.zh.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zhanggq
 * @since 2019-10-11
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getUsers() {
        return userInfoMapper.getUsers();
    }

    @Override
    public List<UserInfo> getUsersExcluseBlob() {
        return userInfoMapper.getUsersExcluseBlob();
    }
}