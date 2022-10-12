package com.YourHouseMyHouse.SwitchHouse.dto.request;

import lombok.*;

import javax.persistence.Column;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HouseInfoDTO {

    //가용 인원
    private Long availablePeople;

    //빌라, 아파트 ...
    private String buildingType;

    //집 전체, 1인실, 다인실...
    private String houseType;

    //방 갯수
    private String numberOfRooms;

    //집 평수
    private String numberOfHouse;

}
