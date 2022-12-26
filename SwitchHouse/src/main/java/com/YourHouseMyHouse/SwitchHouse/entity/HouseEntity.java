package com.YourHouseMyHouse.SwitchHouse.entity;

import com.YourHouseMyHouse.SwitchHouse.common.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "House")
public class HouseEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseId;

    @Column(length = 1000)
    private String houseName;

    @Column(length = 8)
    private Long postalCode;

    @Column(length = 255)
    private String address;

    @Column(length = 255)
    private String detailedAddress;

    @Column(length = 20)
    private String tagAddress;

    @Column(length = 2000)
    private String houseIntroduction;

    @Column(length = 10)
    private String region;

    //오픈 카카오톡 링크
    @Column(length = 1000)
    private String messageLink;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private List<HouseImageEntity> houseImageList = new ArrayList<>();

    @OneToOne(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private HouseInfoEntity houseInfo;

    @OneToOne(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private HouseAmenityEntity houseAmenities;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private List<PrecautionEntity> precautionList = new ArrayList<>();

    public void setHouseInfo(HouseInfoEntity houseInfo) {
        this.houseInfo = houseInfo;
    }
}
