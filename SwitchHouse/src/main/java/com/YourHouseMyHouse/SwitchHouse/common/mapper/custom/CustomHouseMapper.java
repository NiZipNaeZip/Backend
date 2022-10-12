package com.YourHouseMyHouse.SwitchHouse.common.mapper.custom;

import com.YourHouseMyHouse.SwitchHouse.dto.request.CreateHouseDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.request.CreateUserDTO;
import com.YourHouseMyHouse.SwitchHouse.entity.*;
import org.springframework.stereotype.Component;

@Component
public class CustomHouseMapper {

    public HouseEntity createHouseDTOToHouseEntity(CreateHouseDTO createHouseDTO) {
        HouseEntity houseEntity = HouseEntity.builder()
                .houseName(createHouseDTO.getHouseName())
                .postalCode(createHouseDTO.getAddressDTO().getPostalCode())
                .address(createHouseDTO.getAddressDTO().getAddress())
                .detailedAddress(createHouseDTO.getAddressDTO().getDetailedAddress())
                //.tagAddress() 태그 주소 파싱 로직 이후 추가
                .user(UserEntity.builder().userId(createHouseDTO.getUserId()).build())
                .houseIntroduction(createHouseDTO.getHouseIntroduction())
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
                .bed(createHouseDTO.getHouseAmenityDTO().getBed())
                .bathtub(createHouseDTO.getHouseAmenityDTO().getBathtub())
                .kitchen(createHouseDTO.getHouseAmenityDTO().getKitchen())
                .elevator(createHouseDTO.getHouseAmenityDTO().getElevator())
                .microwave(createHouseDTO.getHouseAmenityDTO().getMicrowave())
                .refrigerator(createHouseDTO.getHouseAmenityDTO().getRefrigerator())
                .airConditioner(createHouseDTO.getHouseAmenityDTO().getAirConditioner())
                .wifi(createHouseDTO.getHouseAmenityDTO().getWifi())
                .tv(createHouseDTO.getHouseAmenityDTO().getWifi())
                .hotWater(createHouseDTO.getHouseAmenityDTO().getHotWater())
                .waterPurifier(createHouseDTO.getHouseAmenityDTO().getWaterPurifier())
                .cookingUtensils(createHouseDTO.getHouseAmenityDTO().getCookingUtensils())
                .tableware(createHouseDTO.getHouseAmenityDTO().getTableware())
                .dryer(createHouseDTO.getHouseAmenityDTO().getDryer())
                .iron(createHouseDTO.getHouseAmenityDTO().getIron())
                .washingMachine(createHouseDTO.getHouseAmenityDTO().getWashingMachine())
                .build();

        return houseAmenity;
    }

}
