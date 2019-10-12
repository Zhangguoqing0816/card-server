package com.card.zh.controller;

import com.card.zh.model.request.LoginRequest;
import com.card.zh.model.session.SessionModel;
import com.card.zh.service.LoginService;
import com.card.zh.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/11 13:15
 */
@RestController
@RequestMapping("/loginController")
@Api(value = "登陆", description = "登陆")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/patchca")
    @ApiOperation(value = "获取验证码", notes = "获取验证码")
    public void patchca(HttpServletRequest request, HttpServletResponse response) throws Exception {
        loginService.patchca(request, response);
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登陆", notes = "用户登录")
    public String login(@RequestBody LoginRequest loginRequest) {
        String result = loginService.loginCheckInfo(loginRequest);
        if (result.contains("ok")) {
            SessionModel sessionModel = loginService.getSessionModel(result.replace("ok", ""));
            return new ResultData<SessionModel>().assembleJsonInfo(0, "登陆成功", sessionModel);
        } else {
            return new ResultData<SessionModel>().assembleJsonInfo(1, result, null);
        }
    }

    @PostMapping("/updatePassword")
    @ApiOperation(value = "修改密码", notes = "修改密码")
    public String update(@RequestBody LoginRequest loginRequest) {
        String result = loginService.updatePassword(loginRequest);
        if (result.contains("ok")) {
            return new ResultData<String>().assembleJsonInfo(0, "登陆成功", null);
        } else {
            return new ResultData<SessionModel>().assembleJsonInfo(1, result, null);
        }
    }
}
