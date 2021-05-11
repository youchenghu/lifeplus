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
public class UserBook {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("book_id")
    private Integer bookId;

    @TableField("get_date")
    private LocalDate getDate;

    @TableField("begin_read_date")
    private LocalDate beginReadDate;

    @TableField("progress")
    private Integer progress;

}
