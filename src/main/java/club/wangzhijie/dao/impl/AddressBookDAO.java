package club.wangzhijie.dao.impl;

import club.wangzhijie.dao.po.AddressBookPO;

import java.util.List;

/**
 * @author 8bit
 */
public interface AddressBookDAO {
    /**
     * 数据库增加操作 以doXXX方式命名
     * @param addressBookPO 增加数据的对象
     * @return 成功标记
     **/
    boolean doCreate(AddressBookPO addressBookPO);

    /**
     * 查询全部数据
     * @return 返回查询结果 一个AddressBookPO对象表示一行记录
     */
    List<AddressBookPO> findAll();

    /**
     * 根据姓名查询
     * @param name 姓名
     * @return AddressBookPO对象
     * @throws Exception 异常向上抛出
     */
    List<AddressBookPO> findName(String name);

    /**
     * 根据姓名删除
     * @param name 用户名
     * @return 成功标记
     * */
    boolean deleteId(String name);

    /**
     * 根据姓名修改,这里用的是直接替换的方式
     * @param name 用户名
     * @param addressBookPO AddressBookPO对象
     * @return 成功标记
     * */
    boolean modifyAddress(String name, AddressBookPO addressBookPO);
}