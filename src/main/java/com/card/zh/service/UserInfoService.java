package com.card.zh.service;

import com.baomidou.mybatisplus.service.IService;
import com.card.zh.entity.UserInfo;
import com.card.zh.entity.UserInfoContent;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author zhanggq
 * @since 2019-10-11
 */
public interface UserInfoService extends IService<UserInfo> {

    public List<UserInfo> getUsers();

    public List<UserInfo> getUsersExcluseBlob();

    public void addUser(UserInfo userInfo, List<UserInfoContent> userInfoContents);
}
