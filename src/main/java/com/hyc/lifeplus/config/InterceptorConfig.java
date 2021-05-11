package com.hyc.lifeplus.config;

import com.hyc.lifeplus.core.web.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：胡友成
 * @date ：2021/5/11
 * @description：
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(pageInterceptor());
    }

    @Bean
    public PageInterceptor pageInterceptor(){
        return new PageInterceptor();
    }
}
