package com.YourHouseMyHouse.SwitchHouse.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Precaution")
public class PrecautionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long precautionId;

    @Column(length = 255)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id")
    private HouseEntity house;

    public void setHouse(HouseEntity house) {
        this.house = house;
    }
}
