package com.card.zh.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.card.zh.entity.Attach;
import com.card.zh.entity.UserInfo;
import com.card.zh.mapper.AttachMapper;
import com.card.zh.mapper.UserInfoMapper;
import com.card.zh.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    @Autowired
////    private UserInfoContentMapper userInfoContentMapper;

    @Autowired
    private AttachMapper attachMapper;


    @Override
    public List<UserInfo> getUsers() {
        return userInfoMapper.getUsers();
    }

    @Override
    @Transactional
    public void addUser(UserInfo userInfo, List<String> attachIdList) {
        userInfoMapper.insert(userInfo);
        //内容图片
        if (null != attachIdList && !attachIdList.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            attachIdList.forEach(attrchId -> {
                Attach attach = attachMapper.selectById(attrchId);
                attach.setDominantId(userInfo.getContent());
                attachMapper.updateById(attach);
            });
        }
    }


}
