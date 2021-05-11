package com.hyc.lifeplus.user.controller;

import com.hyc.lifeplus.object.entity.Book;
import com.hyc.lifeplus.object.service.BookService;
import com.hyc.lifeplus.user.entity.User;
import com.hyc.lifeplus.user.entity.UserBook;
import com.hyc.lifeplus.user.entity.UserCar;
import com.hyc.lifeplus.user.service.UserBookService;
import com.hyc.lifeplus.user.service.UserCarService;
import com.hyc.lifeplus.user.service.UserService;
import com.hyc.lifeplus.user.vo.UserBookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ：胡友成
 * @Date ：2021/5/5 11:18 下午
 * @Description：
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserCarService userCarService;

    @Autowired
    UserBookService userBookService;

    @Autowired
    BookService bookService;

    @GetMapping("/get")
    public User getUser(@RequestParam Integer userId){
        return userService.getById(userId);
    }

    @GetMapping("/myCars")
    public List<UserCar> listUserCars(@RequestParam Integer userId){
        return userCarService.listUserCars(userId);
    }

    @GetMapping("/myBooks")
    public List<UserBookVO> listUserBooks(@RequestParam Integer userId){
        List<UserBook> userBooks = userBookService.listUserBooks(userId);

        return userBooks.stream().map(ub->{
            UserBookVO vo = new UserBookVO();
            vo.setUserId(userId);
            vo.setBookId(ub.getBookId());

            Book book = bookService.getById(ub.getBookId());
            vo.setBookName(book.getBookName());
            vo.setAuthor(book.getAuthor());
            vo.setPublishDate(book.getPublishDate());
            vo.setGetDate(ub.getGetDate());
            vo.setBeginReadDate(ub.getBeginReadDate());
            vo.setShortDescription(book.getShortDescription());

            return vo;
        }).collect(Collectors.toList());
    }
}
