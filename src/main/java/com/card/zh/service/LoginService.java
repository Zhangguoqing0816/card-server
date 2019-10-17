package com.card.zh.service;

import com.card.zh.entity.UserInfo;
import com.card.zh.model.request.LoginRequest;
import com.card.zh.model.session.SessionModel;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.font.RandomFontFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/9 15:32
 */
@Service
public class LoginService {
    private static HttpSession session = null;

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 获取验证码
     * @param request
     * @param response
     * @throws Exception
     */
    public void patchca(HttpServletRequest request, HttpServletResponse response) throws Exception {
        session = request.getSession();
        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
        RandomFontFactory ff = new RandomFontFactory();
        ff.setMinSize(30);
        ff.setMaxSize(30);
        RandomWordFactory rwf = new RandomWordFactory();
        rwf.setMinLength(4);
        rwf.setMaxLength(4);
        cs.setWordFactory(rwf);
        cs.setFontFactory(ff);
        cs.setHeight(30);
        cs.setWidth(100);
        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        long time = System.currentTimeMillis();
        response.setDateHeader("Last-Modified", time);
        response.setDateHeader("Date", time);
        response.setDateHeader("Expires", time);
        ServletOutputStream stream = response.getOutputStream();
        String validateCode = EncoderHelper.getChallangeAndWriteImage(cs, "png", stream);
        session.setAttribute("validateCode", validateCode);
        stream.flush();
    }

    /**
     * 登陆校验
     *
     * @param request
     * @return
     */
    public String loginCheckInfo(LoginRequest request) {
        Map<String, Object> map = new HashMap<>();
        //map.put("account", request.getAccount());
        map.put("email", request.getEmail());
        List<UserInfo> userInfos = userInfoService.selectByMap(map);
        String result = "ok";
        if (userInfos.isEmpty()) {
            result = "登陆失败，没有此账号";
        } else if (!userInfos.get(0).getPassword().equals(request.getPassword())) {
            result = "登陆失败，密码错误";
        } else if (!((String) session.getAttribute("validateCode")).equals(request.getAuthCode())) {
            result = "登陆失败，验证码错误";
        } else {
            //result += userInfos.get(0).getAccount();
            result += userInfos.get(0).getEmail();
        }
        return result;
    }

    /**
     * 根据登陆账号查询信息
     *
     * @param email
     * @return
     */
    public SessionModel getSessionModel(String email) {
        SessionModel sessionModel = new SessionModel();
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        List<UserInfo> userInfos = userInfoService.selectByMap(map);
        if (userInfos.isEmpty()) {
            return new SessionModel();
        }
        UserInfo userInfo = userInfos.get(0);
        BeanUtils.copyProperties(userInfo, sessionModel);
        return sessionModel;
    }

    /**
     * 修改密码
     *
     * @param request
     * @return
     */
    public String updatePassword(LoginRequest request) {
        String result = "ok";
        Map<String, Object> map = new HashMap<>();
//        map.put("account", request.getAccount());
        map.put("email", request.getEmail());
        List<UserInfo> userInfos = userInfoService.selectByMap(map);
        if (userInfos.isEmpty()) {
            result = "没有查询到此人";
        } else if (!userInfos.get(0).getPassword().equals(request.getPassword())) {
            result = "原密码错误";
        } else {
            UserInfo userInfo = userInfos.get(0);
            userInfo.setPassword(request.getNewPassword());
            userInfoService.insert(userInfo);
        }
        return result;
    }
}
