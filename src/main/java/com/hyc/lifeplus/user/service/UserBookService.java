package com.hyc.lifeplus.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hyc.lifeplus.user.entity.UserBook;

import java.util.List;

/**
 * @Author ：胡友成
 * @Date ：2021/5/10
 * @Description：
 */
public interface UserBookService extends IService<UserBook> {

    /**
     * 获取用户的图书列表
     * @param userId
     * @return
     */
    List<UserBook> listUserBooks(Integer userId);
}
