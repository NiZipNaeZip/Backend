package com.YourHouseMyHouse.SwitchHouse.repository;

import com.YourHouseMyHouse.SwitchHouse.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
