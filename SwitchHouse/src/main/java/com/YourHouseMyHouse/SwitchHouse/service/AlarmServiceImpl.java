package com.YourHouseMyHouse.SwitchHouse.service;

import com.YourHouseMyHouse.SwitchHouse.common.mapper.custom.CustomAlarmMapper;
import com.YourHouseMyHouse.SwitchHouse.dto.request.SendNoticeReqDTO;
import com.YourHouseMyHouse.SwitchHouse.entity.AlarmEntity;
import com.YourHouseMyHouse.SwitchHouse.repository.AlarmRepository;
import com.YourHouseMyHouse.SwitchHouse.service.interfaces.AlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlarmServiceImpl implements AlarmService {

    private final AlarmRepository alarmRepository;
    private final CustomAlarmMapper customAlarmMapper;

    @Override
    public void sendNotice(SendNoticeReqDTO sendNoticeReqDTO) {
        AlarmEntity alarm = customAlarmMapper.sendNoticeReqDTOTOAlarmEntity(sendNoticeReqDTO);

        alarmRepository.save(alarm);
    }

    @Override
    public void acceptNotice() {

    }

    @Override
    public void refuseNotice() {

    }
}
