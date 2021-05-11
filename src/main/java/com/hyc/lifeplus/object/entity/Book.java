package com.hyc.lifeplus.object.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author ：胡友成
 * @date ：2021/5/10 9:14 下午
 * @description：
 */
@Data
public class Book {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("book_name")
    private String bookName;

    @TableField("author")
    private String author;

    @TableField("publish_date")
    private LocalDate publishDate;

    private String shortDescription;
}
