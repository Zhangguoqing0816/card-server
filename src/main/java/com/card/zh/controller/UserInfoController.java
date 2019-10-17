package com.card.zh.controller;

import com.card.zh.entity.UserInfo;
import com.card.zh.model.request.UserInfoRequest;
import com.card.zh.service.UserInfoService;
import com.card.zh.util.BeanUtil;
import com.card.zh.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
    @PostMapping("/addUser")
    public ResultData add(@RequestBody UserInfoRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", request.getEmail());
        List<UserInfo> userInfos = userInfoService.selectByMap(map);
        if (!userInfos.isEmpty()) {
            return ResultData.error("已存在相同的邮箱");
        }
        UserInfo userInfo = new UserInfo();
        BeanUtil.copyProperties(request, userInfo);
        userInfo.setId(genSeqNo("U", 5));
        List<String> attachIdList = request.getAttachIdList();
        if (null != attachIdList && !attachIdList.isEmpty()) {
            userInfo.setContent(genSeqNo("UC", 5));
        }
        userInfoService.addUser(userInfo, attachIdList);
        return ResultData.success("插入成功", userInfo.getId());
    }

    @ApiOperation(value = "查询全部用户", notes = "查询全部用户")
    @GetMapping("/getUsers")
    public ResultData getUser() {
        List<UserInfo> users = userInfoService.getUsers();
        return ResultData.success("search成功", users);
    }

    @ApiOperation(value = "根据用户的属性查询用户", notes = "根据用户的属性查询用户")
    @GetMapping("/selectByParams")
    public ResultData selectByParams(UserInfo userInfo) {
        UserInfo user = userInfoService.selectByParams(userInfo);
        return ResultData.success("search成功", user);
    }

}
