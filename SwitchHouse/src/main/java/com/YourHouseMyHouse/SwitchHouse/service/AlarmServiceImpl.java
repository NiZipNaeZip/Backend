package com.YourHouseMyHouse.SwitchHouse.service;

import com.YourHouseMyHouse.SwitchHouse.common.mapper.custom.CustomAlarmMapper;
import com.YourHouseMyHouse.SwitchHouse.dto.request.SendNoticeReqDTO;
import com.YourHouseMyHouse.SwitchHouse.entity.AlarmEntity;
import com.YourHouseMyHouse.SwitchHouse.repository.AlarmRepository;
import com.YourHouseMyHouse.SwitchHouse.service.interfaces.AlarmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
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
    @Transactional
    public void acceptNotice(Long alarmId) {
        Optional<AlarmEntity> alarmEntityOptional = alarmRepository.findById(alarmId);

        AlarmEntity alarmEntity = alarmEntityOptional.orElseThrow(RuntimeException::new);

        log.info(alarmEntity.toString());

        alarmEntity.acceptNotice();

        log.info(alarmEntity.toString());
    }

    @Override
    @Transactional
    public void refuseNotice(Long alarmId) {
        Optional<AlarmEntity> alarmEntityOptional = alarmRepository.findById(alarmId);

        AlarmEntity alarmEntity = alarmEntityOptional.orElseThrow(RuntimeException::new);

        alarmEntity.rejectNotice();
    }
}
