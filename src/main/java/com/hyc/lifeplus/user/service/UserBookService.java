package com.hyc.lifeplus.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hyc.lifeplus.user.entity.UserBook;

import java.util.List;

/**
 * @author ：胡友成
 * @date ：2021/5/10
 * @description：
 */
public interface UserBookService extends IService<UserBook> {

    /**
     * 获取用户的图书列表
     * @param userId
     * @return
     */
    List<UserBook> listUserBooks(Integer userId);
}
