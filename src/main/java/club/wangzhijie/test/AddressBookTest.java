package club.wangzhijie.test;

import club.wangzhijie.dao.impl.AddressBookMapper;
import club.wangzhijie.dao.po.AddressBookPO;
import club.wangzhijie.dao.vo.AddressBookVO;
import org.junit.Test;

/**
 * @author 朱文静
 */
public class AddressBookTest {
    @Test
    public void test01() {
        AddressBookPO addressBookPO = new AddressBookPO(1, "abc", "abc", "abc");
        AddressBookVO addressBookVO = AddressBookMapper.MAPPER.po2vo(addressBookPO);
        addressBookPO = AddressBookMapper.MAPPER.vo2po(addressBookVO);
    }
}
