package com.YourHouseMyHouse.SwitchHouse.repository;

import com.YourHouseMyHouse.SwitchHouse.entity.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseRepository extends JpaRepository<HouseEntity, Long> {

    @Query("select distinct h from House h join fetch h.houseImageList join fetch h.houseInfo where h.tagAddress = :region")
    List<HouseEntity> findByTagAddress(String region);
}
