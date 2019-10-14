package com.card.zh.controller;

import com.card.zh.entity.UserInfo;
import com.card.zh.entity.UserInfoContent;
import com.card.zh.model.request.UserInfoRequest;
import com.card.zh.service.UserInfoContentService;
import com.card.zh.service.UserInfoService;
import com.card.zh.util.BeanUtil;
import com.card.zh.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/11 9:46
 */
@RestController
@RequestMapping("userInfo/")
@Api(value = "人员管理", description = "人员管理")
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoContentService userInfoContentService;

    @ApiOperation(value = "addUser", notes = "addUser")
    @PostMapping("/addUser")
    public String add(UserInfoRequest request) {
        UserInfo userInfo = new UserInfo();
        BeanUtil.copyProperties(request, userInfo);
        userInfo.setId(genSeqNo("U", 5));
        List<UserInfoContent> userInfoContentList = new ArrayList<>();
        if (null != request.getUserInfoContentList() && !request.getUserInfoContentList().isEmpty()) {
            userInfoContentList = request.getUserInfoContentList();
            userInfoContentList.forEach(userInfoContent -> {
                userInfoContent.setId(genSeqNo("UC", 5));
                userInfoContent.setUserInfoId(userInfo.getId());
            });
        }
        userInfoService.addUser(userInfo, userInfoContentList);
        return new ResultData<String>().assembleJsonInfo(0, "插入成功", null);
    }

    @ApiOperation(value = "getUsers", notes = "getUsers")
    @PostMapping("/getUsers")
    public String getUser() {
        List<UserInfo> users = userInfoService.getUsers();
        return new ResultData<List<UserInfo>>().assembleJsonInfo(0, "search成功", users);
    }

}
