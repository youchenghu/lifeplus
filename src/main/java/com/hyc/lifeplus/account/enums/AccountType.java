package com.hyc.lifeplus.account.enums;

/**
 * @author ：胡友成
 * @date ：2021/5/11 10:15 下午
 * @description：
 */
public enum AccountType {

    //
    WECHAT("微信"),
    ALIPAY("支付宝"),
    CASH("现金");

    private String description;

    AccountType(String description) {
        this.description = description;
    }
}
