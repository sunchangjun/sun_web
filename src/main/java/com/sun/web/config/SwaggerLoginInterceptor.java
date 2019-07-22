//package com.sun.web.config;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.ModelAndView;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
///**
// * @author ：suncj
// * @date ：2019/7/17 11:40
// */
//public class SwaggerLoginInterceptor  implements HandlerInterceptor {
//    private Logger logger = LoggerFactory.getLogger(SwaggerLoginInterceptor.class);
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//    System.out.println("拦截访问验证");
////        UserInfo user = (UserInfo)request.getSession().getAttribute(GlobalConst.USER_SESSION_KEY);
////        logger.info(request.getRequestURI().toString());
////        if (user == null || user.equals(""))  {
////            response.sendRedirect("/login");
////            logger.info("请先登录");
////            return false;
////        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        logger.info("postHandle...");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        logger.info("afterCompletion...");
//    }
//}
