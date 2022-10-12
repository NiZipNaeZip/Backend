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
    private Long availablePeople;

    //빌라, 아파트 ...
    @Column(length = 10)
    private String buildingType;

    //집 전체, 1인실, 다인실...
    @Column(length = 10)
    private String houseType;

    //방 갯수
    @Column(length = 10)
    private String numberOfRooms;

    //집 평수
    @Column(length = 10)
    private String numberOfHouse;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id")
    private HouseEntity house;

    public void setHouse(HouseEntity house) {
        this.house = house;
    }
}
