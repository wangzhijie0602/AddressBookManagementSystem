package club.wangzhijie.dao.impl;

import club.wangzhijie.dao.po.AddressBookPO;
import club.wangzhijie.dao.vo.AddressBookVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author 8bit
 */
@Mapper
public interface AddressBookMapper {
    AddressBookMapper MAPPER = Mappers.getMapper(AddressBookMapper.class);

    /**
     * AddressBookPO转AddressBookVO
     * @param addressBookPO AddressBookPO对象
     * @return AddressBookVO对象
     * */
    @Mappings ({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "telephone", target = "telephone"),
            @Mapping(source = "mail", target = "mail")
    })
    AddressBookVO po2vo(AddressBookPO addressBookPO);

    /**
     * AddressBookVO转AddressBookVO
     * @param addressBookVO AddressBookVO对象
     * @return AddressBookPO对象
     * */
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "telephone", target = "telephone"),
            @Mapping(source = "mail", target = "mail")
    })
    AddressBookPO vo2po(AddressBookVO addressBookVO);

    /**
     * List<AddressBookPO>转List<AddressBookVO>
     * @param addressBookPOList List<AddressBookPO>
     * @return List<AddressBookVO>
     * */
    List<AddressBookVO> listpo2vo(List<AddressBookPO> addressBookPOList);
}
