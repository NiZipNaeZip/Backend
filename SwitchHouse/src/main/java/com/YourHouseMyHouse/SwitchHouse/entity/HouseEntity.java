package com.YourHouseMyHouse.SwitchHouse.entity;

import com.YourHouseMyHouse.SwitchHouse.common.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "House")
public class HouseEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseId;

    @Column(length = 30)
    private String houseName;

    @Column(length = 8)
    private Long postalCode;

    @Column(length = 255)
    private String address;

    @Column(length = 255)
    private String detailedAddress;

    @Column(length = 20)
    private String tagAddress;

    @Column(length = 255)
    private String houseIntroduction;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private List<HouseImage> houseImageList = new ArrayList<>();

    @OneToOne(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private HouseInfoEntity houseInfo;

    @OneToOne(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private HouseAmenitiesEntity houseAmenities;
}
