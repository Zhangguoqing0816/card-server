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

    @ApiOperation(value = "addUser", notes = "addUser")
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

    @ApiOperation(value = "getUsers", notes = "getUsers")
    @GetMapping("/getUsers")
    public ResultData getUser() {
        List<UserInfo> users = userInfoService.getUsers();
        return ResultData.success("search成功", users);
    }

}
