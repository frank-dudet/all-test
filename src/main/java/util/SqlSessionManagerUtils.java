package util;

import com.cn.frank.test.dbcompare.SystemPropertyKeys;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author wangjian
 *
 */
public class SqlSessionManagerUtils {

    private static Logger LOG = Logger.getLogger(SqlSessionManagerUtils.class);

    private static ThreadLocal<SqlSession> sqlSessionThreadLocal = new ThreadLocal<>();

    public static final String jtdsDriverName = "net.sourceforge.jtds.jdbc.Driver";
    public static final String odbcDrivername = "sun.jdbc.odbc.JdbcOdbcDriver";

    private static class SqlSessionFactoryHelper {

        static SqlSessionFactory sqlSessionFactory;
        static {
            try {
                sqlSessionFactory = loadProperties();
            } catch (Exception e) {
                LOG.error("获取数据库异常", e);
                sqlSessionFactory = null;
            }
        }

        /**
         * 加载属性
         *
         * @return
         * @throws Exception
         */
        public static SqlSessionFactory loadProperties() throws Exception {

            ResourceBundle bundle = ResourceBundle.getBundle("sixun_v4-jdbc");
            String dbUrl = System.getProperty(SystemPropertyKeys.KEY_DB_NAME_SRC, bundle.getString("url")).trim();
            String dbUserName = System
                    .getProperty(SystemPropertyKeys.KEY_PLUGIN_DB_USER, bundle.getString("username")).trim();
            String dbPassword = System
                    .getProperty(SystemPropertyKeys.KEY_PLUGIN_DB_PWD, bundle.getString("password")).trim();
            Properties properties = new Properties();
            properties.setProperty("url", dbUrl);
            properties.setProperty("username", dbUserName);
            properties.setProperty("password", dbPassword);
            properties.setProperty("driver", jtdsDriverName);
            if("jdbc:odbc:MTDP".equalsIgnoreCase(dbUrl)) {
                properties.setProperty("driver", odbcDrivername);
                LOG.info(String.format("数据源存在，odbc方式获取连接,url:%s, userName:%s, password:%s -----", dbUrl, dbUserName, dbPassword));
            }
            return new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("config/mybatis/mybatis.xml"), properties);

        }
    }

    /**
     * 获取sqlSession
     *
     * @param autoCommit
     *            false 手动提交事物 true 自动提交事物
     * @return
     */
    public static SqlSession getSqlSession(boolean autoCommit) {
        SqlSession sqlSession = sqlSessionThreadLocal.get();
        if (sqlSession == null) {
            SqlSessionFactory sqlSessionFactory = SqlSessionFactoryHelper.sqlSessionFactory;
            if (sqlSessionFactory == null) {
                return null;
            }
            sqlSession = sqlSessionFactory.openSession(autoCommit);
            sqlSessionThreadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭sqlSession
     */
    public static void closeSqlSession() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionThreadLocal.get();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
                sqlSessionThreadLocal.remove();
            }
        }
    }

}
