package com.hyc.lifeplus.core.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.net.URI;

/**
 * @author ：胡友成
 * @date ：2021/5/11
 * @description：
 */
@Order(2)
@Slf4j
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

        // swagger的相关请求不拦截
        Class<?> containingClass = returnType.getContainingClass();
        return !containingClass.getName().contains("swagger");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        // swagger的api-docs不进行拦截
        URI uri = request.getURI();
        if (uri.getPath() != null && uri.getPath().contains("api-docs")) {
            return body;
        }

        final String returnTypeName = returnType.getParameterType().getName();
        if ("void".equals(returnTypeName)) {
            return GlobalResponse.success(null);
        }

        return GlobalResponse.success(body);
    }
}
