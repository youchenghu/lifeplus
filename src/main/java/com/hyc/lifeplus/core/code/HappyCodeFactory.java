package com.hyc.lifeplus.core.code;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author ：胡友成
 * @date ：2021/5/11 10:54 上午
 * @description：
 */
public class HappyCodeFactory {

    /**
     * 数据源配置
     */
    private DataSourceConfig dataSource;

    /**
     * 数据库表配置
     */
    private StrategyConfig strategy;

    /**
     * 包 相关配置
     */
    private PackageConfig packageConfig;

    /**
     * 模板 相关配置
     */
    private TemplateConfig template;

    /**
     * 全局 相关配置
     */
    private GlobalConfig globalConfig;

    /**
     * 模板引擎
     */
    private AbstractTemplateEngine templateEngine;

    /**
     * 自定义配置
     */
    private InjectionConfig injectionConfig;

    public HappyCodeFactory() {
        this.globalConfig = new GlobalConfig()
                // 是否打开输出目录
                .setOpen(false)
                // 是否覆盖文件
                .setFileOverride(true)
                // 开启 swagger2 模式
                .setSwagger2(true)
                // 开启 activeRecord 模式
                .setActiveRecord(false)
                // XML 二级缓存
                .setEnableCache(false)
                // XML ResultMap
                .setBaseResultMap(true)
                // XML columnList
                .setBaseColumnList(true)
                // 时间类型对应策略
                .setDateType(DateType.TIME_PACK)
                .setServiceName("%sService")
                .setEntityName("%s");

        this.templateEngine = new FreemarkerTemplateEngine();
        this.dataSource = new DataSourceConfig();
        this.packageConfig = new PackageConfig()
                .setParent("com.hyc.cs.generate")
                .setMapper("dao");

        this.template = new TemplateConfig()
                .setController("")
                .setXml("")
                .setEntity("/templates/entity.java")
                .setMapper("/templates/mapper.java")
                .setService("/templates/service.java")
                .setServiceImpl("/templates/serviceImpl.java");

        this.strategy = new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setSkipView(false)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                .setEntityTableFieldAnnotationEnable(true)
                .setEntitySerialVersionUID(false);

        this.injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                this.setMap(new HashMap<>());
            }

            @Override
            public Map<String, Object> prepareObjectMap(Map<String, Object> objectMap) {
                objectMap.put("datetime", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now()));

                TableInfo tableInfo = (TableInfo) objectMap.get("table");

                if (tableInfo.getComment() == null) {
                    tableInfo.setComment("");
                }

                TableField keyTableField = null;
                for (TableField field : tableInfo.getFields()) {
                    if (field.isKeyFlag() && keyTableField == null) {
                        keyTableField = field;
                    }
                    if (field.getComment() == null) {
                        field.setComment("");
                    }
                }

                Map<String, Object> map = new HashMap<>();
                map.put("mapperVariateName", tableInfo.getMapperName().substring(0, 1).toLowerCase() + tableInfo.getMapperName().substring(1));
                map.put("serviceVariateName", tableInfo.getServiceName().substring(0, 1).toLowerCase() + tableInfo.getServiceName().substring(1));
                map.put("entityVariateName", tableInfo.getEntityName().substring(0, 1).toLowerCase() + tableInfo.getEntityName().substring(1));
//                map.put("entitySimpleName", tableInfo.getEntityName().substring(0, tableInfo.getEntityName().length() - 6));
                map.put("keyTableField", keyTableField);
                objectMap.put("cs", map);

                return super.prepareObjectMap(objectMap);
            }
        };


    }

    /**
     * 生成文件的输出目录
     */
    public HappyCodeFactory setOutputDir(String outputDir) {
        this.globalConfig.setOutputDir(outputDir);
        return this;
    }

    /**
     * 作者
     */
    public HappyCodeFactory setAuthor(String author) {
        this.globalConfig.setAuthor(author);
        return this;
    }

    /**
     * 设置数据源
     */
    public HappyCodeFactory setDataSource(String jdbcURL, String driverName, String username, String password) {
        this.dataSource.setUrl(jdbcURL);
        this.dataSource.setDriverName(driverName);
        this.dataSource.setUsername(username);
        this.dataSource.setPassword(password);
        return this;
    }

    /**
     * 包名配置
     */
    public HappyCodeFactory setPackageName(String packageName) {
        this.packageConfig.setParent(packageName);
        return this;
    }

    /**
     * 表名配置
     */
    public HappyCodeFactory setTableName(String... tableName) {
        this.strategy.setInclude(tableName);
        return this;
    }

    /**
     * 表前缀配置
     */
    public HappyCodeFactory setTablePrefix(String... tablePrefix) {
        this.strategy.setTablePrefix(tablePrefix);
        return this;
    }

    public void build() {
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(this.globalConfig);
        mpg.setDataSource(this.dataSource);
        mpg.setPackageInfo(this.packageConfig);
        mpg.setCfg(this.injectionConfig);
        mpg.setTemplate(this.template);
        mpg.setStrategy(this.strategy);
        mpg.setTemplateEngine(this.templateEngine);
        mpg.execute();
    }
}
