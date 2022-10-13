package com.YourHouseMyHouse.SwitchHouse.service.interfaces;

import com.YourHouseMyHouse.SwitchHouse.dto.request.CreateHouseDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.response.ViewDetailHouseResDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.response.ViewRegionHouseResDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HouseService {
    void createHouse (List<MultipartFile> images, CreateHouseDTO createHouseDTO) throws Exception;
    List<ViewRegionHouseResDTO> viewRegionHouse(String region);
    ViewDetailHouseResDTO viewDetailHouse(Long houseId);
}
