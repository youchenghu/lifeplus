package com.hyc.lifeplus.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyc.lifeplus.user.dao.UserCarMapper;
import com.hyc.lifeplus.user.dao.UserMapper;
import com.hyc.lifeplus.user.entity.User;
import com.hyc.lifeplus.user.entity.UserCar;
import com.hyc.lifeplus.user.service.UserCarService;
import com.hyc.lifeplus.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：胡友成
 * @date ：2021/5/10
 * @description：
 */
@Service
public class UserCarServiceImpl extends ServiceImpl<UserCarMapper, UserCar> implements UserCarService {

    @Override
    public List<UserCar> listUserCars(Integer userId) {
        QueryWrapper<UserCar> qw = new QueryWrapper<>();
        qw.eq("user_id", userId);
        return list(qw);
    }
}
