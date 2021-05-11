package com.hyc.lifeplus.account.enums;

/**
 * @author ：胡友成
 * @date ：2021/5/11 10:15 下午
 * @description：
 */
public enum AccountingType {

    //
    INCOME("收入"),
    EXPENSE("支出");

    private String description;

    AccountingType(String description) {
        this.description = description;
    }
}
