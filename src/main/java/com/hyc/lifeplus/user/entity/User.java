package com.hyc.lifeplus.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ：胡友成
 * @date ：2021/5/5 11:28 下午
 * @description：
 */
@Data
@TableName("user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("nickname")
    private String nickname;

    @TableField("phone")
    private String phone;

}
