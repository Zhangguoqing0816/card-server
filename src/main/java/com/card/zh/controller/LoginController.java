package com.card.zh.controller;

import com.card.zh.model.request.LoginRequest;
import com.card.zh.model.session.SessionModel;
import com.card.zh.service.LoginService;
import com.card.zh.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
    @ApiImplicitParam(name="request",value = "验证码请求对象",required = true,dataTypeClass =HttpServletResponse.class)
    public void patchca(HttpServletRequest request, HttpServletResponse response) throws Exception {
        loginService.patchca(request, response);
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登陆", notes = "用户登录")
    @ApiImplicitParam(name="loginRequest",value = "登录用户",required = true,dataTypeClass= LoginRequest.class)
    public ResultData login(@RequestBody LoginRequest loginRequest) {
        String result = loginService.loginCheckInfo(loginRequest);
        if (result.contains("ok")) {
            SessionModel sessionModel = loginService.getSessionModel(result.replace("ok", ""));
            return ResultData.success("登陆成功", sessionModel);
        } else {
            return ResultData.error(result);
        }
    }

    @PostMapping("/updatePassword")
    @ApiOperation(value = "修改密码", notes = "修改密码")
    @ApiImplicitParam(name="loginRequest",value = "用户的密码信息",required = true,dataTypeClass= LoginRequest.class)
    public ResultData update(@RequestBody LoginRequest loginRequest) {
        String result = loginService.updatePassword(loginRequest);
        if (result.contains("ok")) {
            return ResultData.success("登陆成功", null);
        } else {
            return ResultData.error(result);
        }
    }

}
