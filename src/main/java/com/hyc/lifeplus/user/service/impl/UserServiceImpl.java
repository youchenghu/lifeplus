package com.hyc.lifeplus.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyc.lifeplus.user.dao.UserMapper;
import com.hyc.lifeplus.user.entity.User;
import com.hyc.lifeplus.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author ：胡友成
 * @date ：2021/5/7 12:10 上午
 * @description：
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
