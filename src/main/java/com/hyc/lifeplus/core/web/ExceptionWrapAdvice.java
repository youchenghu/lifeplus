package com.hyc.lifeplus.core.web;

import com.google.common.base.Throwables;
import com.hyc.lifeplus.core.exception.HappyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ：胡友成
 * @date ：2021/5/11
 * @description：
 */
@ControllerAdvice
@Slf4j
public class ExceptionWrapAdvice<T> {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({HappyException.class})
    public <T> GlobalResponse<T> handleException(HappyException e) {
        log.error(Throwables.getStackTraceAsString(e));
        return GlobalResponse.fail(e.getMessage());
    }
}
