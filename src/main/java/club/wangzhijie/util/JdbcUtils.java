package club.wangzhijie.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author 8bit
 */
public class JdbcUtils {
    private static final String DRIVE;
    private static final String URL;
    private static final String NAME;
    private static final String PASSWORD;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("./src/main/resources/jdbc.properties"));
            DRIVE = properties.getProperty("jdbc.drive");
            URL = properties.getProperty("jdbc.url");
            NAME = properties.getProperty("jdbc.name");
            PASSWORD = properties.getProperty("jdbc.password");
            Class.forName(DRIVE);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, NAME, PASSWORD);
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }
}
