package com.YourHouseMyHouse.SwitchHouse.controller;

import com.YourHouseMyHouse.SwitchHouse.dto.request.SendNoticeReqDTO;
import com.YourHouseMyHouse.SwitchHouse.service.interfaces.AlarmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/notice")
public class AlarmController {

    private final AlarmService alarmService;

    @PostMapping("/send")
    public ResponseEntity<Void> sendNotice(@RequestBody SendNoticeReqDTO sendNoticeReqDTO) {
        alarmService.sendNotice(sendNoticeReqDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
