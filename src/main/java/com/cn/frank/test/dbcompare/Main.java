package com.cn.frank.test.dbcompare;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import util.JdbcUtils;
import util.ResultSetToList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * Author: frank_du
 * Time : 2018/3/19 下午3:01
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    private static final String SELECT_TABLES_SQL = "SELECT name from sysobjects where type='U'";

    private static final String SELECT_ALL_COLUMNS_SQL = "SELECT TABLE_NAME, COLUMN_NAME ,  DATA_TYPE, COLUMN_DEFAULT, " +
            "IS_NULLABLE, CHARACTER_MAXIMUM_LENGTH,COLUMNPROPERTY(object_id(TABLE_NAME), COLUMN_NAME, 'IsIdentity') as IsIdentity" +
            "FROM INFORMATION_SCHEMA.COLUMNS";

    public static void main(String[] args) {
        // TODO: 2018/3/19 接收上层传过来的参数信息
        getBDInfo();
        Connection srcConnection = null;
        Connection destConnection = null;

        String srcUrl = System.getProperty(SystemPropertyKeys.KEY_SRC_PLUGIN_DB_URL);
        String destUrl = System.getProperty(SystemPropertyKeys.KEY_DEST_PLUGIN_DB_URL);
        String username = System.getProperty(SystemPropertyKeys.KEY_PLUGIN_DB_USER);
        String password = System.getProperty(SystemPropertyKeys.KEY_PLUGIN_DB_PWD);
        try {
            srcConnection = JdbcUtils.getConnection(srcUrl, username, password);
            destConnection = JdbcUtils.getConnection(destUrl, username, password);
            //查询数据库表名
            List<String> srcTableNames = getTableNames(srcConnection);
            if(CollectionUtils.isEmpty(srcTableNames)) {
                LOGGER.error("查询源数据库表名结果为空");
            }
            List<String> destTableNames = getTableNames(destConnection);
            if(CollectionUtils.isEmpty(destTableNames)) {
                LOGGER.error("查询目标数据库表名结果为空");
            }

            List<DBColumnPO> srcDBInfos = getDBColumnInfos(srcConnection);
            if(CollectionUtils.isEmpty(srcDBInfos)) {
                LOGGER.error("查询源数据库表结构信息结果为空");
            }
            List<DBColumnPO> destDBInfos = getDBColumnInfos(destConnection);
            if(CollectionUtils.isEmpty(destDBInfos)) {
                LOGGER.error("查询目标数据库表结构信息结果为空");
            }

            new CompareDBService().compare(srcTableNames, destTableNames, srcDBInfos, destDBInfos);

        } catch (Exception e) {
            LOGGER.error("未知异常", e);
            e.printStackTrace();
        } finally {
            JdbcUtils.closeQuietly(srcConnection, destConnection);
        }


    }

    /**
     * 获取数据库表结构信息
     *
     * @param connection
     * @return
     */
    private static List<DBColumnPO> getDBColumnInfos(Connection connection) throws Exception {
        List<DBColumnPO> DBColumnInfos = new ArrayList<DBColumnPO>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(SELECT_ALL_COLUMNS_SQL);
            rs = stmt.executeQuery();
            DBColumnInfos = ResultSetToList.convertRS(rs, DBColumnPO.class);
        } finally {
            JdbcUtils.closeQuietly(rs, stmt);
        }
        return DBColumnInfos;
    }

    /**
     * 获取tableNames
     *
     * @param connection
     * @return
     * @throws Exception
     */
    private static List<String> getTableNames(Connection connection) throws Exception {
        List<String> tableNames = new ArrayList<String>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(SELECT_TABLES_SQL);
            rs = stmt.executeQuery();
            while(rs.next()) {
                String tableName = rs.getString(1);
                tableNames.add(tableName);
            }
        } finally {
            JdbcUtils.closeQuietly(rs, stmt);
        }

        return tableNames;
    }

    private static void getBDInfo() {

    }
}
