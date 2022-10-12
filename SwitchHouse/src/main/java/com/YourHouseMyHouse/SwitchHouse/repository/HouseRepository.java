package com.YourHouseMyHouse.SwitchHouse.repository;

import com.YourHouseMyHouse.SwitchHouse.entity.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<HouseEntity, Long> {
}
