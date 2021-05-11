package com.hyc.lifeplus.object;

import com.hyc.lifeplus.object.entity.Book;
import com.hyc.lifeplus.object.service.BookService;
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
@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/list")
    public List<Book> listAll(){
        return bookService.list();
    }
}
