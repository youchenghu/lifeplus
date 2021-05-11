package com.hyc.lifeplus.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author ：胡友成
 * @date ：2021/5/10 9:38 下午
 * @description：
 */

@Data
public class UserCar {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("car_brand")
    private String carBrand;

    @TableField("sku")
    private String sku;

    @TableField("license_plate_number")
    private String licensePlateNumber;

}
