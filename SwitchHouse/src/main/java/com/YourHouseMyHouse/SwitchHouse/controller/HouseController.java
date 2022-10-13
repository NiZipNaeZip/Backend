package com.YourHouseMyHouse.SwitchHouse.controller;

import com.YourHouseMyHouse.SwitchHouse.dto.request.CreateHouseDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.response.ViewDetailHouseResDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.response.ViewRegionHouseResDTO;
import com.YourHouseMyHouse.SwitchHouse.service.interfaces.HouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/house")
public class HouseController {

    private final HouseService houseService;

    @PostMapping("/create")
    public ResponseEntity<Void> createHouse(@RequestPart List<MultipartFile> images, @RequestPart CreateHouseDTO createHouseDTO) {
        try {

            houseService.createHouse(images, createHouseDTO);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/{region}")
    public ResponseEntity<List<ViewRegionHouseResDTO>> viewRegionHouse(@PathVariable String region) {
        List<ViewRegionHouseResDTO> viewRegionHouseResDTOList = houseService.viewRegionHouse(region);

        return new ResponseEntity<>(viewRegionHouseResDTOList, HttpStatus.OK);
    }

    @GetMapping("/detail/{houseId}")
    public ResponseEntity<ViewDetailHouseResDTO> viewDetailHouse(@PathVariable Long houseId) {
        ViewDetailHouseResDTO viewDetailHouseResDTO = houseService.viewDetailHouse(houseId);

        return new ResponseEntity<>(viewDetailHouseResDTO, HttpStatus.OK);
    }
}
