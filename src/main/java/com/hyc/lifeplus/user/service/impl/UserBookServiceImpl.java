package com.hyc.lifeplus.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyc.lifeplus.user.dao.UserBookMapper;
import com.hyc.lifeplus.user.entity.UserBook;
import com.hyc.lifeplus.user.service.UserBookService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ：胡友成
 * @Date ：2021/5/10
 * @Description：
 */
@Service
public class UserBookServiceImpl extends ServiceImpl<UserBookMapper, UserBook> implements UserBookService {
    @Override
    public List<UserBook> listUserBooks(Integer userId) {
        QueryWrapper<UserBook> qw = new QueryWrapper<>();
        qw.eq("user_id", userId);
        return list(qw);
    }
}
