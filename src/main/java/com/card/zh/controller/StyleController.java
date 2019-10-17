package com.card.zh.controller;

import com.card.zh.entity.UserInfo;
import com.card.zh.model.request.StyleRequest;
import com.card.zh.service.UserInfoService;
import com.card.zh.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/17 14:28
 */
@RestController
@RequestMapping("style/")
@Api(value = "风格", description = "风格")
public class StyleController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "设置界面风格", notes = "设置界面风格")
    @PostMapping("/setStyle")
    public ResultData setStyle(@RequestBody StyleRequest request) {
        UserInfo userInfo = userInfoService.selectById(request.getUserInfoId());
        if (Objects.isNull(userInfo)) {
            return ResultData.error("设置风格操作失败，没有查到对应用户的账号");
        }
        userInfo.setPageStyle(request.getStyleId());
        userInfoService.updateById(userInfo);
        return ResultData.error("已存在相同的邮箱");
    }
}
