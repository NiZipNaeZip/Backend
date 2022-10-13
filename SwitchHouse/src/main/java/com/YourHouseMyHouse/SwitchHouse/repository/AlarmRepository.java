package com.YourHouseMyHouse.SwitchHouse.repository;

import com.YourHouseMyHouse.SwitchHouse.entity.AlarmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlarmRepository extends JpaRepository<AlarmEntity, Long> {

//    @Query("select distinct a from Alarm a join fetch a.sender join fetch a.sender.house where a.receiver.userId = :receiverId")
    @Query("select distinct a from Alarm a join fetch a.sender where a.receiver.userId = :receiverId")
    List<AlarmEntity> findAllByReceiver(Long receiverId);
}
