package club.wangzhijie.test;

import club.wangzhijie.util.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 朱文静
 */
public class JdbcUtilsTest {

    @Test
    public void test01() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        JdbcUtils.closeAll(connection, null, null);
    }
}
