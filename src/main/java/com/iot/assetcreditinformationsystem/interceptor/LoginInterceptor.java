package com.iot.assetcreditinformationsystem.interceptor;

import com.iot.assetcreditinformationsystem.util.token.Token;
import com.iot.assetcreditinformationsystem.util.token.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //从请求中获取token字符串并转换成Token对象
//        String tokenStr = httpServletRequest.getParameter("token");
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.INDENT_OUTPUT,true);
//        Token token = mapper.readValue(tokenStr,Token.class);
        boolean flag=false;
        String userIdStr = httpServletRequest.getParameter("userid");
        String digest = httpServletRequest.getParameter("digest");
        if (userIdStr==null || digest==null){
            logger.info("未传入token，已拦截");
        }
        else {
            Token token = new Token(Integer.valueOf(userIdStr),digest);
            if (tokenUtil.validToken(token)){
                flag = true;
                logger.info("用户id:"+token.getUserId()+",验证通过，放行");
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
