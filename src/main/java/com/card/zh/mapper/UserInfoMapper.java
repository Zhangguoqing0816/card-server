package com.card.zh.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.card.zh.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    UserInfo selectByPrimaryKey(String id);

    int deleteByPrimaryKey(String id);

    Integer insert(UserInfo record);

    int insertSelective(UserInfo record);

    int updateByPrimaryKeyWithBLOBs(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    public List<UserInfo> getUsers();

}