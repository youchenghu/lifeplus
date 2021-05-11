package com.hyc.lifeplus.user.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @Author ：胡友成
 * @Date ：2021/5/10 10:10 下午
 * @Description：
 */
@Data
public class UserBookVO {

    private Integer userId;

    private Integer bookId;

    private String bookName;

    private String author;

    private LocalDate publishDate;

    private String shortDescription;

    private LocalDate getDate;

    private LocalDate beginReadDate;
}
