package com.YourHouseMyHouse.SwitchHouse.dto.request;

import lombok.*;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateHouseDTO {

    private Long userId;

    private AddressDTO addressDTO;
    private HouseInfoDTO houseInfoDTO;
    private HouseAmenityDTO houseAmenityDTO;

    private String houseName;
    private String houseIntroduction;

    private List<String> precautionList;

    private String messageLink;
}
