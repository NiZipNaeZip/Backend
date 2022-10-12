package com.YourHouseMyHouse.SwitchHouse.service.interfaces;

import com.YourHouseMyHouse.SwitchHouse.dto.request.CreateHouseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HouseService {
    void createHouse (List<MultipartFile> images, CreateHouseDTO createHouseDTO) throws Exception;
}
