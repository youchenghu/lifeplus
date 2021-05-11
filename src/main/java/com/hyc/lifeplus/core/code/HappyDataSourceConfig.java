package com.hyc.lifeplus.core.code;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.IDbQuery;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.*;
import com.baomidou.mybatisplus.generator.config.querys.*;
import com.hyc.lifeplus.core.exception.HappyException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ：胡友成
 * @date ：2021/5/11 2:40 下午
 * @description：
 */
public class HappyDataSourceConfig extends DataSourceConfig {

    /**
     * 数据库信息查询
     */
    private IDbQuery dbQuery;

    /**
     * 数据库类型
     */
    private DbType dbType;

    /**
     * 类型转换
     */
    private ITypeConvert typeConvert;

    /**
     * 数据源
     */
    private DataSource dataSource;

    public HappyDataSourceConfig(DataSource dataSource, DbType dbType) {
        this.dataSource = dataSource;
        this.dbType = dbType;
    }

    @Override
    public IDbQuery getDbQuery() {
        if (null == dbQuery) {
            switch (getDbType()) {
                case ORACLE:
                    dbQuery = new OracleQuery();
                    break;
                case SQL_SERVER:
                    dbQuery = new SqlServerQuery();
                    break;
                case POSTGRE_SQL:
                    dbQuery = new PostgreSqlQuery();
                    break;
                case DB2:
                    dbQuery = new DB2Query();
                    break;
                case MARIADB:
                    dbQuery = new MariadbQuery();
                    break;
                case H2:
                    dbQuery = new H2Query();
                    break;
                case SQLITE:
                    dbQuery = new SqliteQuery();
                    break;
                case DM:
                    dbQuery = new DMQuery();
                    break;
                default:
                    // 默认 MYSQL
                    dbQuery = new MySqlQuery();
                    break;
            }
        }
        return dbQuery;
    }

    /**
     * 判断数据库类型
     *
     * @return 类型枚举值
     */
    @Override
    public DbType getDbType() {
        return this.dbType;
    }


    @Override
    public ITypeConvert getTypeConvert() {
        if (null == typeConvert) {
            switch (getDbType()) {
                case ORACLE:
                    typeConvert = new OracleTypeConvert();
                    break;
                case SQL_SERVER:
                    typeConvert = new SqlServerTypeConvert();
                    break;
                case POSTGRE_SQL:
                    typeConvert = new PostgreSqlTypeConvert();
                    break;
                case DB2:
                    typeConvert = new DB2TypeConvert();
                    break;
                case SQLITE:
                    typeConvert = new SqliteTypeConvert();
                    break;
                case DM:
                    typeConvert = new DmTypeConvert();
                    break;
                case MARIADB:
                    typeConvert = new MySqlTypeConvert();
                    break;
                default:
                    // 默认 MYSQL
                    typeConvert = new MySqlTypeConvert();
                    break;
            }
        }
        return typeConvert;
    }

    /**
     * 创建数据库连接对象
     *
     * @return Connection
     */
    @Override
    public Connection getConn() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new HappyException("数据源错误！", e);
        }
    }
}
