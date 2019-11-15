package com.sun.web.interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author ：suncj
 * @date ：2019/10/25 16:12
 * 注册:拦截器实现类
 */
@Configuration
public class WebConfigService implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器拦截,访问swagger页面
        // 注册拦截器
        LogInSwagger2Interceptor loginInterceptor = new LogInSwagger2Interceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // 拦截路径
        loginRegistry.addPathPatterns("/swagger-ui.html");
//        // 排除路径
//        loginRegistry.excludePathPatterns("/");
//        loginRegistry.excludePathPatterns("/login");
//        loginRegistry.excludePathPatterns("/loginout");
//        // 排除资源请求
//        loginRegistry.excludePathPatterns("/css/login/*.css");
//        loginRegistry.excludePathPatterns("/js/login/**/*.js");
//        loginRegistry.excludePathPatterns("/image/login/*.png");

    }

}
