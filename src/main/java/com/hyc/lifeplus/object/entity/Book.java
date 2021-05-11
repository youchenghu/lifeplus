package com.hyc.lifeplus.object.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Author ：胡友成
 * @Date ：2021/5/10 9:14 下午
 * @Description：
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
