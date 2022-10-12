package com.YourHouseMyHouse.SwitchHouse.entity;

import com.YourHouseMyHouse.SwitchHouse.common.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "HouseInfo")
public class HouseInfoEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseInfoId;

    @Column(length = 10)
    private String houseType;

    @Column(length = 10)
    private Long availablePeople;

    @Column(length = 10)
    private String buildingType;

    @Column(length = 10)
    private String numberOfRooms;

    @Column(length = 10)
    private String numberOfHouse;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id")
    private HouseEntity house;
}
