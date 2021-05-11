package com.hyc.lifeplus.core.web;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author ：胡友成
 * @date ：2021/5/11
 * @description：
 */
public class PageInfo {
    public static ThreadLocal<IPage> pageThreadLocal = new ThreadLocal<>();

    public static void set(IPage iPage) {
        pageThreadLocal.set(iPage);
    }

    public static IPage get() {
        return pageThreadLocal.get();
    }

    public static void remove() {
        pageThreadLocal.remove();
    }
}
