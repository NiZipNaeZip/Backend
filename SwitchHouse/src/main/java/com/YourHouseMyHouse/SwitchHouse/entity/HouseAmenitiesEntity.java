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
@Entity(name = "HouseAmenities")
public class HouseAmenitiesEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseAmenitiesId;

    @Column(length = 10)
    private Boolean Bed;

    @Column(length = 10)
    private Boolean bathtub;

    @Column(length = 10)
    private Boolean kitchen;

    @Column(length = 10)
    private Boolean elevator;

    @Column(length = 10)
    private Boolean microwave;

    @Column(length = 10)
    private Boolean refrigerator;

    @Column(length = 10)
    private Boolean airConditioner;

    @Column(length = 10)
    private Boolean wifi;

    @Column(length = 10)
    private Boolean tv;

    @Column(length = 10)
    private Boolean hotWater;

    @Column(length = 10)
    private Boolean waterPurifier;

    @Column(length = 10)
    private Boolean cookingUtensils;

    @Column(length = 10)
    private Boolean tableware;

    @Column(length = 10)
    private Boolean Dryer;

    @Column(length = 10)
    private Boolean Iron;

    @Column(length = 10)
    private Boolean washingMachine;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id")
    private HouseEntity house;
}
