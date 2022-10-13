package com.YourHouseMyHouse.SwitchHouse.common.mapper.custom;

import com.YourHouseMyHouse.SwitchHouse.common.handler.ParseTagAddress;
import com.YourHouseMyHouse.SwitchHouse.dto.HouseInfoDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.request.CreateHouseDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.response.ViewRegionHouseResDTO;
import com.YourHouseMyHouse.SwitchHouse.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomHouseMapper {

    private final ParseTagAddress parseTagAddress;

    public HouseEntity createHouseDTOToHouseEntity(CreateHouseDTO createHouseDTO) {
        HouseEntity houseEntity = HouseEntity.builder()
                .houseName(createHouseDTO.getHouseName())
                .postalCode(createHouseDTO.getAddressDTO().getPostalCode())
                .address(createHouseDTO.getAddressDTO().getAddress())
                .detailedAddress(createHouseDTO.getAddressDTO().getDetailedAddress())
                .tagAddress(parseTagAddress.parseTagAddressFromAddress(createHouseDTO.getAddressDTO().getAddress()))
                .user(UserEntity.builder().userId(createHouseDTO.getUserId()).build())
                .houseIntroduction(createHouseDTO.getHouseIntroduction())
                .region(createHouseDTO.getRegion())
                .messageLink(createHouseDTO.getMessageLink())
                .build();

        return houseEntity;
    }

    public HouseInfoEntity createHouseDTOToHouseInfoEntity(CreateHouseDTO createHouseDTO) {
        HouseInfoEntity houseInfo = HouseInfoEntity.builder()
                .availablePeople(createHouseDTO.getHouseInfoDTO().getAvailablePeople())
                .buildingType(createHouseDTO.getHouseInfoDTO().getBuildingType())
                .houseType(createHouseDTO.getHouseInfoDTO().getHouseType())
                .numberOfRooms(createHouseDTO.getHouseInfoDTO().getNumberOfRooms())
                .numberOfHouse(createHouseDTO.getHouseInfoDTO().getNumberOfHouse())
                .build();

        return houseInfo;
    }

    public HouseAmenityEntity createHouseDTOTOHouseAmenityEntity(CreateHouseDTO createHouseDTO) {
        HouseAmenityEntity houseAmenity = HouseAmenityEntity.builder()
                .beach(createHouseDTO.getHouseAmenityDTO().getBeach())
                .olleTrail(createHouseDTO.getHouseAmenityDTO().getOlleTrail())
                .pickingTangerine(createHouseDTO.getHouseAmenityDTO().getPickingTangerine())
                .activity(createHouseDTO.getHouseAmenityDTO().getActivity())
                .sportsEquipment(createHouseDTO.getHouseAmenityDTO().getSportsEquipment())
                .waterPlayEquipment(createHouseDTO.getHouseAmenityDTO().getWaterPlayEquipment())
                .culturalLife(createHouseDTO.getHouseAmenityDTO().getCulturalLife())
                .hotPlace(createHouseDTO.getHouseAmenityDTO().getHotPlace())
                .build();

        return houseAmenity;
    }

    public ViewRegionHouseResDTO houseEntityToViewRegionHouseResDTO(HouseEntity house) {
        HouseInfoDTO houseInfoDTO = HouseInfoDTO.builder()
                .availablePeople(house.getHouseInfo().getAvailablePeople())
                .houseType(house.getHouseInfo().getHouseType())
                .numberOfHouse(house.getHouseInfo().getNumberOfHouse())
                .buildingType(house.getHouseInfo().getBuildingType())
                .numberOfRooms(house.getHouseInfo().getNumberOfRooms())
                .build();

        ViewRegionHouseResDTO viewRegionHouseResDTO = ViewRegionHouseResDTO.builder()
                .houseId(house.getHouseId())
                .address(house.getAddress())
                .houseName(house.getHouseName())
                .houseInfoDTO(houseInfoDTO)
                .region(house.getRegion())
                .filePath(house.getHouseImageList().get(0).getFilePath())
                .build();

        return viewRegionHouseResDTO;
    }
}
