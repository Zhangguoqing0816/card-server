package com.card.zh.comp.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
 * @Date: 2019/10/11 14:38
 */
@Component
@Slf4j
@WebFilter(urlPatterns = {"/api/*"}, filterName = "filter")
public class Filter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request, response);
            return;
        }
        log.info(String.format("%s request to %s", request.getMethod(), request.getRemoteAddr() + request.getRequestURL().toString()));
        if (StringUtils.contains(request.getRequestURL().toString(), "/loginController/login")
                || StringUtils.contains(request.getRequestURL().toString(), "/login")
                || StringUtils.contains(request.getRequestURL().toString(), "/loginController/patchca")
                || StringUtils.contains(request.getRequestURL().toString(), "swagger")
                || StringUtils.contains(request.getRequestURL().toString(), "api-docs")) {
            filterChain.doFilter(request, response);
            return;
        }
        String email = request.getHeader("authorization");
        if (StringUtils.isBlank(email)) {
            log.info("No Login.....Please go to Login.....");
            response.setStatus(403);
            return;
        }

        log.info("email save ok -->" + email);
        filterChain.doFilter(request, response);
    }
}

