package com.YourHouseMyHouse.SwitchHouse.dto.request;

import lombok.*;

import javax.persistence.Column;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HouseAmenityDTO {

    private Boolean beach;
    private Boolean olleTrail;
    private Boolean pickingTangerine;
    private Boolean activity;
    private Boolean sportsEquipment;
    private Boolean waterPlayEquipment;
    private Boolean culturalLife;
    private Boolean hotPlace;
}
