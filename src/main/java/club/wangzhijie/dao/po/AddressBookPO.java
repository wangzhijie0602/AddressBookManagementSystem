package club.wangzhijie.dao.po;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 通讯录
 * @author 8bit
 */
@Data
@AllArgsConstructor
public class AddressBookPO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String telephone;
    private String mail;

    public Object[] toObjectArray() {
        return new Object[]{getId(), getName(), getTelephone(), getMail()};
    }

}