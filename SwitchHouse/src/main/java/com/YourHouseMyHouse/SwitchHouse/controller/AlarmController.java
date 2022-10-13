package com.YourHouseMyHouse.SwitchHouse.controller;

import com.YourHouseMyHouse.SwitchHouse.dto.request.SendNoticeReqDTO;
import com.YourHouseMyHouse.SwitchHouse.service.interfaces.AlarmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/accept/{alarmId}")
    public ResponseEntity<Void> acceptNotice(@PathVariable Long alarmId) {
        try {
            alarmService.acceptNotice(alarmId);

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reject/{alarmId}")
    public ResponseEntity<Void> rejectNotice(@PathVariable Long alarmId) {
        try {
            alarmService.refuseNotice(alarmId);

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
