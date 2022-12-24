package club.wangzhijie.test;

import club.wangzhijie.dao.impl.AddressBookDAO;
import club.wangzhijie.dao.AddressBookDAOImpl;
import org.junit.Test;

/**
 * @author 朱文静
 */
public class AddressBookDAOImplTest {
    @Test
    public void test01() {
        AddressBookDAO addressBookDAO =  new AddressBookDAOImpl();
        addressBookDAO.findAll();
    }
}
