package com.YourHouseMyHouse.SwitchHouse.common.mapper;

import com.YourHouseMyHouse.SwitchHouse.dto.HouseInfoDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.request.HouseAmenityDTO;
import com.YourHouseMyHouse.SwitchHouse.entity.HouseAmenityEntity;
import com.YourHouseMyHouse.SwitchHouse.entity.HouseInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HouseAmenityMapper {

    HouseAmenityMapper INSTANCE = Mappers.getMapper(HouseAmenityMapper.class);

    //@Mapping(target = "houseAmenityId", ignore = true)
    //@Mapping(target = "house", ignore = true)
    HouseAmenityDTO toDTO(HouseAmenityEntity houseAmenityEntity);
}
