package com.hyc.lifeplus.core.exception;

import cn.hutool.core.util.StrUtil;

import java.util.function.Supplier;

/**
 * @author ：胡友成
 * @date ：2021/5/11 2:42 下午
 * @description：
 */
public class HappyException extends RuntimeException{

    private Integer code;

    private String errorMessage;

    public HappyException(String errorMessage) {
        super(errorMessage);
        this.code = 500;
        this.errorMessage = errorMessage;
    }

    public HappyException(String errorMessage, Object ... arguments) {
        this(StrUtil.format(errorMessage, arguments));
    }

    public HappyException(Integer code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public HappyException(Integer code, String errorMessage, Object ... arguments) {
        this(code, StrUtil.format(errorMessage, arguments));
    }

    public static Supplier<HappyException> HappyExceptionSupplier(String message) {
        return () -> new HappyException(message);
    }

    public static Supplier<HappyException> HappyExceptionSupplier(Integer code, String message) {
        return () -> new HappyException(code, message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
