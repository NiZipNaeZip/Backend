package com.YourHouseMyHouse.SwitchHouse.common.mapper;

import com.YourHouseMyHouse.SwitchHouse.dto.request.CreateUserDTO;
import com.YourHouseMyHouse.SwitchHouse.entity.UserEntity;
import org.hibernate.annotations.Target;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "sendAlarmList", ignore = true)
    @Mapping(target = "receiveAlarmList", ignore = true)
    UserEntity toEntity(CreateUserDTO createUserDTO);
}
