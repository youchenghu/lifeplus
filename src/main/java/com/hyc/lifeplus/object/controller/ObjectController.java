package com.hyc.lifeplus.object.controller;

import com.hyc.lifeplus.object.entity.Book;
import com.hyc.lifeplus.object.entity.CommonSense;
import com.hyc.lifeplus.object.service.BookService;
import com.hyc.lifeplus.object.service.CommonSenseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：胡友成
 * @date ：2021/5/10 9:11 下午
 * @description：
 */
@Api(tags = "物品服务")
@RequestMapping("/object")
@RestController
public class ObjectController {

    @Autowired
    BookService bookService;

    @Autowired
    CommonSenseService commonSenseService;

    @ApiOperation("获取图书列表")
    @GetMapping("/book/list")
    public List<Book> listAllBook(){
        return bookService.list();
    }

    @ApiOperation("获取常识列表")
    @GetMapping("/commonSense/list")
    public List<CommonSense> listAllCommonSense(){
        return commonSenseService.list();
    }
}
