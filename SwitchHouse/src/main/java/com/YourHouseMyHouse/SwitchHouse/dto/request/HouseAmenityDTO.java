package com.YourHouseMyHouse.SwitchHouse.dto.request;

import lombok.*;

import javax.persistence.Column;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HouseAmenityDTO {
    private Boolean bed;
    private Boolean bathtub;
    private Boolean kitchen;
    private Boolean elevator;
    private Boolean microwave;
    private Boolean refrigerator;
    private Boolean airConditioner;
    private Boolean wifi;
    private Boolean tv;
    private Boolean hotWater;
    private Boolean waterPurifier;
    private Boolean cookingUtensils;
    private Boolean tableware;
    private Boolean dryer;
    private Boolean iron;
    private Boolean washingMachine;
}
