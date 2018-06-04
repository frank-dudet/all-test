package util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by pengfei.feng on 17/2/13.
 */
public class JdbcUtils {
    private static final Logger LOGGER = Logger.getLogger(JdbcUtils.class);

    public static final String driverName = "net.sourceforge.jtds.jdbc.Driver";
    public static final String driverNameOdbc = "sun.jdbc.odbc.JdbcOdbcDriver";

    public static Connection getConnection(String url, String username, String password) throws SQLException {
        try {
            if("jdbc:odbc:MTDP".equalsIgnoreCase(url)) {
                Class.forName(driverNameOdbc);
                Properties prop = new Properties();
                prop.put("charSet", "gbk");
                prop.put("user", username);
                prop.put("password", password);
                LOGGER.info(String.format("数据源存在，odbc方式获取连接,url:%s, userName:%s, password:%s -----", url, username, password));
                return DriverManager.getConnection(url, prop);
            	
            } else {
            	LOGGER.info("----使用jtds数据源---");
            	Class.forName(driverName);
            	return DriverManager.getConnection(url, username, password);
            }
        } catch (Exception e) {
            LOGGER.error("init jdbc connection error", e);
            throw new SQLException("init jdbc connection error", e);
        }
    }

    public static void closeQuietly(AutoCloseable... objs) {
        if (objs == null || objs.length <= 0) {
            return;
        }

        for (AutoCloseable obj : objs) {
            if (obj != null) {
                try {
                    obj.close();
                } catch (Exception e) {
                    LOGGER.error("close resource error: " + obj, e);
                } finally {
                    if(obj != null) {
                        try {
                            obj.close();
                        } catch (Exception e) {
                            LOGGER.error("close resource error: " + obj, e);
                        }
                    }
                }
            }
        }
    }
}
