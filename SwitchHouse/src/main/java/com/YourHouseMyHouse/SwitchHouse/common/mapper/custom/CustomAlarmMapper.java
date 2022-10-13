package com.YourHouseMyHouse.SwitchHouse.common.mapper.custom;

import com.YourHouseMyHouse.SwitchHouse.dto.request.SendNoticeReqDTO;
import com.YourHouseMyHouse.SwitchHouse.entity.AlarmEntity;
import com.YourHouseMyHouse.SwitchHouse.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAlarmMapper {

    public AlarmEntity sendNoticeReqDTOTOAlarmEntity(SendNoticeReqDTO sendNoticeReqDTO) {
        AlarmEntity alarmEntity = AlarmEntity.builder()
                .startDate(sendNoticeReqDTO.getStartDate())
                .endDate(sendNoticeReqDTO.getEndDate())
                .sender(UserEntity.builder().userId(sendNoticeReqDTO.getSenderId()).build())
                .receiver(UserEntity.builder().userId(sendNoticeReqDTO.getReceiverId()).build())
                .build();

        return alarmEntity;
    }
}
