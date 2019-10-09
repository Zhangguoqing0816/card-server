package com.card.zh.service;

import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.font.RandomFontFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/9 15:32
 */
public class LoginService {
    private static HttpSession session = null;

    /**
     * 获取验证码
     *
     * @param request
     * @param response
     * @throws Exception
     */
    public void patchca(HttpServletRequest request,
                        HttpServletResponse response) throws Exception {
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
        String validateCode = EncoderHelper.getChallangeAndWriteImage(cs,
                "png", stream);
        session.setAttribute("validateCode", validateCode);
        stream.flush();
    }
}
