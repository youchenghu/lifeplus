package com.hyc.lifeplus.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hyc.lifeplus.user.entity.UserCar;

import java.util.List;

/**
 * @author ：胡友成
 * @date ：2021/5/10
 * @description：
 */
public interface UserCarService extends IService<UserCar> {

    /**
     * 获取用户的汽车列表
     * @param userId
     * @return
     */
    List<UserCar> listUserCars(Integer userId);
}
