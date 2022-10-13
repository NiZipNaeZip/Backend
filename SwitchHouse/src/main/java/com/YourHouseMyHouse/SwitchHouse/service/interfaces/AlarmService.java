package com.YourHouseMyHouse.SwitchHouse.service.interfaces;

import com.YourHouseMyHouse.SwitchHouse.dto.request.SendNoticeReqDTO;
import io.swagger.models.Response;
import org.springframework.http.ResponseEntity;

public interface AlarmService {
    void sendNotice(SendNoticeReqDTO sendNoticeReqDTO);
    void acceptNotice(Long alarmId);
    void refuseNotice(Long alarmId);
}
