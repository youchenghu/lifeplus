package com.hyc.lifeplus.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Author ：胡友成
 * @Date ：2021/5/10 9:38 下午
 * @Description：
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
