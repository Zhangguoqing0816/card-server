package com.card.zh.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.card.zh.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    public List<UserInfo> getUsers();

    UserInfo selectByParams(UserInfo userInfo);

}