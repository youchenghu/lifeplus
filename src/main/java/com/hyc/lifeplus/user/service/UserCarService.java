package com.hyc.lifeplus.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hyc.lifeplus.user.entity.UserCar;

import java.util.List;

/**
 * @Author ：胡友成
 * @Date ：2021/5/10
 * @Description：
 */
public interface UserCarService extends IService<UserCar> {

    /**
     * 获取用户的汽车列表
     * @param userId
     * @return
     */
    List<UserCar> listUserCars(Integer userId);
}
