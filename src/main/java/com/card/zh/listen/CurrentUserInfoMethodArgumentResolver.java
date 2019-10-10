package com.card.zh.listen;

import com.card.zh.annotation.CurrentUser;
import com.card.zh.model.session.SessionModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/9 15:28
 */
public class CurrentUserInfoMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private final static Logger log = LoggerFactory.getLogger(CurrentUserInfoMethodArgumentResolver.class);

//    @Autowired
//    private LoginService loginService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(SessionModel.class)
                && parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Nullable
    @Override
    public Object resolveArgument(MethodParameter methodParameter, @Nullable ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, @Nullable WebDataBinderFactory webDataBinderFactory) throws Exception {
        String accessToken = nativeWebRequest.getHeader("Authorization");
        SessionModel userModel = new SessionModel();
        // to do
        return userModel;
    }
}
