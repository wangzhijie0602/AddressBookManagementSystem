package club.wangzhijie.dao;

import club.wangzhijie.dao.impl.AddressBookDAO;
import club.wangzhijie.dao.po.AddressBookPO;
import club.wangzhijie.util.BaseDao;

import java.util.List;

/**
 * @author 母丹婷
 */
public class AddressBookDAOImpl extends BaseDao implements AddressBookDAO {
    @Override
    public boolean doCreate(AddressBookPO addressBookPO) {
        String sql = "INSERT INTO address_book values (?, ?, ?, ?)";
        return executeUpdateSql(sql, addressBookPO.toObjectArray()) != 0;
    }

    @Override
    public List<AddressBookPO> findAll() {
        String sql = "SELECT * FROM address_book";
        return executeSelectSql(sql, new Object[]{});
    }

    @Override
    public List<AddressBookPO> findName(String name) {
//        Modify by 8bit at 2022/12/24
        String sql = "SELECT * FROM address_book WHERE name LIKE ?\"%\"";
//        String sql = "SELECT * FROM address_book WHERE name = ?";
        return executeSelectSql(sql, new Object[]{name});
    }

    @Override
    public boolean deleteId(String name) {
        String sql = "DELETE FROM address_book WHERE name = ?";
        return executeUpdateSql(sql, new Object[]{name}) != 0;
    }

    @Override
    public boolean modifyAddress(String name, AddressBookPO addressBookPO) {
        String sql = "UPDATE address_book SET name = ?, telephone = ?, mail = ? WHERE name = ?";
        Object[] object = new Object[4];
        Object[] addressBookPOObjectArray = addressBookPO.toObjectArray();
        for (int i = 1;i < addressBookPOObjectArray.length;i++) {
            object[i - 1] = addressBookPOObjectArray[i];
        }
        object[3] = name;
        return executeUpdateSql(sql, object) != 0;
    }
}