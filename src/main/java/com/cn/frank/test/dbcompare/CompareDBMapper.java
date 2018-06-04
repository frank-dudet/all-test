package com.cn.frank.test.dbcompare;

import java.util.List;

/**
 * Author: frank_du
 * Time : 2018/3/19 下午2:51
 */
public interface CompareDBMapper {

    List<String> selectTableNames();

    List<String> selectColunmsByTable(String tableName);
}
