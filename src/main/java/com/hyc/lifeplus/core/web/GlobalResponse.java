package com.hyc.lifeplus.core.web;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author ：胡友成
 * @date ：2021/5/11
 * @description：
 */
@Data
public class GlobalResponse<T> {

    @JSONField(serialize = false)
    protected boolean success = true;
    private T data;
    private Integer code;
    private String msg;

    public GlobalResponse(T data, boolean success) {
        this.success = success;
        this.data = data;
        this.code = success ? 0 : -2;
        this.msg = success ? "success" : null;
    }

    public static <T> GlobalResponse<T> success(T data) {
        return new GlobalResponse<>(data, true);
    }

    public static <T> GlobalResponse<T> fail(String msg) {
        GlobalResponse<T> response = new GlobalResponse<>(null, false);
        response.setMsg(msg);
        return response;
    }

    public static GlobalResponse<String> unknownFail(String msg) {
        GlobalResponse<String> response = new GlobalResponse<>(msg, false);
        response.setMsg("系统异常");
        return response;
    }
}
