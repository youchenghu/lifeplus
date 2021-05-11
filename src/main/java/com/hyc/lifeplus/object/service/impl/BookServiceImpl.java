package com.hyc.lifeplus.object.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyc.lifeplus.object.dao.BookMapper;
import com.hyc.lifeplus.object.entity.Book;
import com.hyc.lifeplus.object.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @Author ：胡友成
 * @Date ：2021/5/10 9:24 下午
 * @Description：
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
}
