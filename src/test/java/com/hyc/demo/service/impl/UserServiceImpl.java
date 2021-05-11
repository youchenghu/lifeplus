package com.hyc.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyc.demo.entity.User;
import com.hyc.demo.dao.UserMapper;
import com.hyc.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 胡友成
 * @date 2021-05-11 16:01
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
