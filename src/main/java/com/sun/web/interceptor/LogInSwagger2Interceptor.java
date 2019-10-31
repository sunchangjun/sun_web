package com.sun.web.interceptor;




import com.alibaba.fastjson.JSONObject;
import com.sun.web.enums.ConstantConfig;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ：suncj
 * @date ：2019/10/25 16:03
 * 拦截器,拦截访问swagger页面
 */
@Log4j2
public class LogInSwagger2Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //预先处理
        log.info("LogInSwagger2Interceptor.preHandle()");
       String saveSessionMessage=(String) request.getSession().getAttribute(ConstantConfig.USER_LOGIN_SESSION);
        log.error("sessionMessage={}",saveSessionMessage);
        if(StringUtils.isNotBlank(saveSessionMessage)){
            return true;
        }else{
            //请先登录
            response.sendRedirect("/login/loginHtml");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    //后处理
    log.info("LogInSwagger2Interceptor.postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    //完成后
        log.info("LogInSwagger2Interceptor.afterCompletion()");
    }
}
