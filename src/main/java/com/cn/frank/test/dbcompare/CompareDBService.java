package com.cn.frank.test.dbcompare;

import com.alibaba.fastjson.JSON;
import com.cn.frank.test.excel.ExcelUtil;
import net.sf.json.JSONArray;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import util.FCollectionUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Author: frank_du
 * Time : 2018/3/19 下午3:00
 */
public class CompareDBService {

    private static final Logger LOGGER = Logger.getLogger(CompareDBService.class);

    public void compare(List<String> srcTableNames, List<String> destTableNames, List<DBColumnPO> srcDBInfos,
                        List<DBColumnPO> destDBInfos) {
        boolean isQueryDbInfo = Boolean.getBoolean(SystemPropertyKeys.KEY_IS_QUERY_DBINFO);
        List<String> nonExistTables = new ArrayList<String>();
        List<DBColumnPO> nonExistColumnPOs = new LinkedList<DBColumnPO>();
        if(isQueryDbInfo) {
            LOGGER.info("----查询数据库信息请求");
            return;
        }
        //查询不包含的表名
        for(String name : srcTableNames) {
            if(!destTableNames.contains(name)) {
                nonExistTables.add(name);
            }
        }
        if(CollectionUtils.isNotEmpty(nonExistTables)) {
            LOGGER.info("-----目标数据库不包含的表名：" + JSON.toJSONString(nonExistTables));
        }

        //查询不包含的列名
        for(String name : srcTableNames) {
            if(nonExistTables.contains(name)) {
                continue;
            }
            List<DBColumnPO> srcColumnPOs = FCollectionUtils.select(srcDBInfos, "tableName", name);
            for(DBColumnPO po : srcColumnPOs) {
                DBColumnPO tmp = FCollectionUtils.findByPropertyValue(destDBInfos, "tableName", name);
                if(null == tmp) {
                    nonExistColumnPOs.add(po);
                }
            }
        }

        if(CollectionUtils.isNotEmpty(nonExistColumnPOs)) {
            LOGGER.error("-----目标数据库不存在的列名：" + JSON.toJSONString(nonExistColumnPOs));
        }

        ExcelUtil.Export2Excel(JSONArray.fromObject(""));
    }
}
