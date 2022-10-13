package com.YourHouseMyHouse.SwitchHouse.repository;

import com.YourHouseMyHouse.SwitchHouse.entity.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseRepository extends JpaRepository<HouseEntity, Long> {

    @Query("select distinct h from House h join fetch h.houseImageList join fetch h.houseInfo where h.region = :region")
    List<HouseEntity> findALLByRegion(String region);

    @Query("select distinct h from House h join fetch h.houseImageList join fetch h.user where h.user.userId = :userId")
    HouseEntity findByUserIdWithImage(Long userId);

    @Query("select distinct h from House h join fetch h.houseImageList join fetch h.user join fetch h.houseInfo join fetch h.houseAmenities where h.houseId = :houseId")
    HouseEntity findByIdWithAmenityANDInfoANDImage(Long houseId);
}
