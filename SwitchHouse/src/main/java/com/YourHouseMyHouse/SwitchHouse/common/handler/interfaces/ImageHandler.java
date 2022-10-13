package com.YourHouseMyHouse.SwitchHouse.common.handler.interfaces;

import com.YourHouseMyHouse.SwitchHouse.entity.HouseImageEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageHandler {

    public List<HouseImageEntity> parseFileInfoImage(List<MultipartFile> multipartFiles) throws Exception;
    List<String> exactFilePath(List<HouseImageEntity> houseImageEntityList);
}
