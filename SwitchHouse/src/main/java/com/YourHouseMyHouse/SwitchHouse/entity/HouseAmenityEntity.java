package com.YourHouseMyHouse.SwitchHouse.entity;

import com.YourHouseMyHouse.SwitchHouse.common.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "HouseAmenity")
public class HouseAmenityEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseAmenityId;

    private Boolean beach;

    private Boolean olleTrail;

    private Boolean pickingTangerine;

    private Boolean activity;

    private Boolean sportsEquipment;

    private Boolean waterPlayEquipment;

    private Boolean culturalLife;

    private Boolean hotPlace;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id")
    private HouseEntity house;

    public void setHouse(HouseEntity house) {
        this.house = house;
    }
}
