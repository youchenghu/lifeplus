package com.hyc.lifeplus;

import com.hyc.lifeplus.core.code.HappyCodeFactory;
import org.junit.Test;

/**
 * @author ：胡友成
 * @date ：2021/5/11 2:52 下午
 * @description：
 */
public class CodeGenerator {

    @Test
    public void testBuild(){
        new HappyCodeFactory()
                .setAuthor("胡友成")
                .setPackageName("com.hyc.demo")
                .setOutputDir(System.getProperty("user.dir") + "/src/test/java")
                .setDataSource(
                        "jdbc:mysql://127.0.0.1:3306/lifeway?characterEncoding=UTF8",
                        "com.mysql.cj.jdbc.Driver",
                        "root",
                        "youki360"
                )
                .setTableName("user")
                .setTablePrefix("")
                .build();
    }
}
