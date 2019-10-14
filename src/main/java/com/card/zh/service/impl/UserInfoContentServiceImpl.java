package com.card.zh.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.card.zh.entity.UserInfoContent;
import com.card.zh.mapper.UserInfoContentMapper;
import com.card.zh.service.UserInfoContentService;
import org.springframework.stereotype.Service;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/14 11:20
 */
@Service
public class UserInfoContentServiceImpl extends ServiceImpl<UserInfoContentMapper, UserInfoContent> implements UserInfoContentService {
}
