package club.wangzhijie.util;

import club.wangzhijie.dao.po.AddressBookPO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 8bit
 */
public class BaseDao {

    public List<AddressBookPO> executeSelectSql(String sql, Object[] param) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    preparedStatement.setObject(i + 1, param[i]);
                }
            }
            ResultSet resultSet =  preparedStatement.executeQuery();
            List<AddressBookPO> addressBookPOList = new LinkedList<>();
            while (resultSet.next()) {
                addressBookPOList.add(new AddressBookPO(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("telephone"),
                        resultSet.getString("mail")));
            }
            return addressBookPOList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtils.closeAll(connection, preparedStatement, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int executeUpdateSql(String sql, Object[] param) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    preparedStatement.setObject(i + 1, param[i]);
                }
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtils.closeAll(connection, preparedStatement, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
