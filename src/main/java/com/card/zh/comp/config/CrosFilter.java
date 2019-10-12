package com.card.zh.comp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/11 14:42
 */
@Component
@WebFilter(urlPatterns = {"/*"}, filterName = "crosFilter")
public class CrosFilter extends OncePerRequestFilter {

    private static Logger log = LoggerFactory.getLogger(CrosFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //所有域都可以访问
        response.setHeader("Access-Control-Allow-Origin", "*");
        //相应类型
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS,PATCH");
        //请求的最大时间
        response.setHeader("Access-Control-Max-Age", "3600");
        //响应头设置
        response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, X-OperatorToken");
        response.addHeader("Access-Control-Expose-Headers", "X-OperatorToken");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, response);
        }
    }

}
