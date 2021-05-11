package com.hyc.lifeplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ：胡友成
 * @Date ：2021/5/5
 * @Description：
 */
@MapperScan("com.hyc.lifeplus.**.dao")
@SpringBootApplication
public class LifeplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeplusApplication.class, args);
    }

}
