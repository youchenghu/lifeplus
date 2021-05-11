package com.hyc.lifeplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：胡友成
 * @date ：2021/5/5
 * @description：
 */
@MapperScan("com.hyc.lifeplus.**.dao")
@SpringBootApplication
public class LifeplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeplusApplication.class, args);
    }

}
