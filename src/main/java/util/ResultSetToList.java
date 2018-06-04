package util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: frank_du
 * Time : 2018/3/19 下午4:54
 */
public class ResultSetToList {
    public static <T> List<T> convertRS(ResultSet rs, Class<T> cls) throws Exception {
        // 检索此 ResultSet 对象的列的编号、类型和属性。
        List<T> list = new ArrayList<T>();
        ResultSetMetaData rsmd = rs.getMetaData();
        // 得到当前的列数
        int colCount = rsmd.getColumnCount();
        Field[] fields = cls.getDeclaredFields();
        while (rs.next()) { // while控制行数
            T obj = cls.newInstance();
            for (int i = 1; i <= colCount; i++) {// for循环控制列数
                String key = rsmd.getColumnName(i);// 得到当前列的列名
                for (int j = 0; j < fields.length; j++) {
                    Field f = fields[j];
                    if (f.getName().equalsIgnoreCase(key)) {
                        f = cls.getDeclaredField(f.getName());// 得到属性的set方法
                        f.setAccessible(true);// 把方法设置为可访问
                        f.set(obj, rs.getObject(i));
                        break;
                    }
                }
            }
            list.add(obj);
        }
        return list;
    }

}
