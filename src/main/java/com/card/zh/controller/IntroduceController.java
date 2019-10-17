package com.card.zh.controller;

import com.card.zh.entity.Introduce;
import com.card.zh.entity.UserInfo;
import com.card.zh.model.request.IntroduceRequest;
import com.card.zh.service.IntroduceService;
import com.card.zh.service.UserInfoService;
import com.card.zh.util.BeanUtil;
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
 * @Date: 2019/10/17 14:17
 */
@RestController
@RequestMapping("/introduce")
@Api(value = "简介", description = "简介")
public class IntroduceController {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private IntroduceService introduceService;

    @ApiOperation(value = "新增简介信息", notes = "新增简介信息")
    @PostMapping("/addIntroduce")
    public ResultData addIntroduce(@RequestBody IntroduceRequest request) {
        UserInfo userInfo = userInfoService.selectById(request.getUserInfoId());
        if (Objects.isNull(userInfo)) {
            return ResultData.error("操作失败，没有查到对应用户的账号");
        }
        Introduce introduce = new Introduce();
        BeanUtil.copyProperties(request, introduce);
        introduceService.insert(introduce);
        return ResultData.success();
    }

}
