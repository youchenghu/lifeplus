package com.hyc.lifeplus.core.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：胡友成
 * @date ：2021/5/11 10:49 下午
 * @description：
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "page", value = "分页页码"),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "size", value = "每页数量"),
})
public @interface Page {
}
