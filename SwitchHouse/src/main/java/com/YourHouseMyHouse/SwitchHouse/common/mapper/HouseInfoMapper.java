package com.YourHouseMyHouse.SwitchHouse.common.mapper;

import com.YourHouseMyHouse.SwitchHouse.dto.HouseInfoDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.request.CreateUserDTO;
import com.YourHouseMyHouse.SwitchHouse.entity.HouseInfoEntity;
import com.YourHouseMyHouse.SwitchHouse.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HouseInfoMapper {

    HouseInfoMapper INSTANCE = Mappers.getMapper(HouseInfoMapper.class);

    //@Mapping(target = "house", ignore = true)
    HouseInfoDTO toDTO(HouseInfoEntity houseInfoEntity);
}
