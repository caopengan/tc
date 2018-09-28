package com.simba.auth.Interceptors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@Configuration
public class LoginInterceptor implements WebMvcConfigurer {

    /**
     * 登录session_key
     */
    public final static String SESSION_KEY = "user";

    @Bean
    public SecurityInterceptor getSecurityInterceptor(){
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        InterceptorRegistration interceptorRegistration = interceptorRegistry.addInterceptor(getSecurityInterceptor());
        //排除配置（url白名单）
        interceptorRegistration.excludePathPatterns("/error");
        interceptorRegistration.excludePathPatterns("login**");
        //拦截配置
        interceptorRegistration.addPathPatterns("/**");
    }


    private class SecurityInterceptor extends HandlerInterceptorAdapter {
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
            HttpSession session = request.getSession();

            //判断是否已有该用户登录的session
            if(session.getAttribute(SESSION_KEY) != null){
                return true;
            }
            //跳转到登录页
            String url = "/login";
            response.sendRedirect(url);
            return false;
        }
    }



}
