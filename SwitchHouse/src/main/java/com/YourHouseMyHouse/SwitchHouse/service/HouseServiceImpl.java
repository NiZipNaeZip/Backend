package com.YourHouseMyHouse.SwitchHouse.service;

import com.YourHouseMyHouse.SwitchHouse.common.handler.PrecautionHandler;
import com.YourHouseMyHouse.SwitchHouse.common.handler.interfaces.ImageHandler;
import com.YourHouseMyHouse.SwitchHouse.common.mapper.HouseAmenityMapper;
import com.YourHouseMyHouse.SwitchHouse.common.mapper.HouseInfoMapper;
import com.YourHouseMyHouse.SwitchHouse.common.mapper.custom.CustomHouseMapper;
import com.YourHouseMyHouse.SwitchHouse.common.mapper.custom.CustomPrecautionMapper;
import com.YourHouseMyHouse.SwitchHouse.dto.HouseInfoDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.request.CreateHouseDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.request.HouseAmenityDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.response.ViewDetailHouseResDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.response.ViewRegionHouseResDTO;
import com.YourHouseMyHouse.SwitchHouse.entity.*;
import com.YourHouseMyHouse.SwitchHouse.repository.*;
import com.YourHouseMyHouse.SwitchHouse.service.interfaces.HouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final ImageHandler imageHandler;
    private final PrecautionHandler precautionHandler;

    private final CustomHouseMapper customHouseMapper;
    private final CustomPrecautionMapper customPrecautionMapper;

    private final HouseRepository houseRepository;
    private final HouseInfoRepository houseInfoRepository;
    private final HouseAmenityRepository houseAmenityRepository;
    private final PrecautionRepository precautionRepository;
    private final HouseImageRepository houseImageRepository;

    /**
     * 집을 생성하는 메서드
     * @param images 집 이미지
     * @param createHouseDTO 집 옵션 관련 정보
     * @throws Exception
     */
    @Override
    public void createHouse(List<MultipartFile> images, CreateHouseDTO createHouseDTO) throws Exception {
        
        //HouseEntity 저장
        HouseEntity house = customHouseMapper.createHouseDTOToHouseEntity(createHouseDTO);
        houseRepository.save(house);

        //HouseInfoEntity 저장
        HouseInfoEntity houseInfo = customHouseMapper.createHouseDTOToHouseInfoEntity(createHouseDTO);
        houseInfo.setHouse(house);
        houseInfoRepository.save(houseInfo);

        //HouseAmenityEntity 저장
        HouseAmenityEntity houseAmenity = customHouseMapper.createHouseDTOTOHouseAmenityEntity(createHouseDTO);
        houseAmenity.setHouse(house);
        houseAmenityRepository.save(houseAmenity);

        //PrecautionEntity 저장
        List<String> commentList = createHouseDTO.getPrecautionList();
        List<PrecautionEntity> precautionEntityList = new ArrayList<PrecautionEntity>();

        for(String comment : commentList) {
            PrecautionEntity precaution = customPrecautionMapper.stringToPrecautionEntity(comment);
            precaution.setHouse(house);

            precautionEntityList.add(precaution);
        }

        precautionRepository.saveAll(precautionEntityList);

        //이미지 파일 변환
        List<HouseImageEntity> houseImageEntityList = imageHandler.parseFileInfoImage(images);

        for(HouseImageEntity houseImage: houseImageEntityList) {
            houseImage.setHouse(house);
        }

        houseImageRepository.saveAll(houseImageEntityList);
    }

    @Override
    public List<ViewRegionHouseResDTO> viewRegionHouse(String region) {
        List<HouseEntity> houseEntityList = houseRepository.findALLByRegion(region);

        List<ViewRegionHouseResDTO> viewRegionHouseResDTOList = new ArrayList<>();

        for(HouseEntity house : houseEntityList) {
            ViewRegionHouseResDTO viewRegionHouseResDTO = customHouseMapper.houseEntityToViewRegionHouseResDTO(house);

            viewRegionHouseResDTOList.add(viewRegionHouseResDTO);
        }

        return viewRegionHouseResDTOList;
    }

    @Override
    public ViewDetailHouseResDTO viewDetailHouse(Long houseId) {
        HouseEntity houseEntity = houseRepository.findByIdWithAmenityANDInfoANDImage(houseId);

        HouseInfoDTO houseInfoDTO = HouseInfoMapper.INSTANCE.toDTO(houseEntity.getHouseInfo());
        HouseAmenityDTO houseAmenityDTO = HouseAmenityMapper.INSTANCE.toDTO(houseEntity.getHouseAmenities());
        List<String> precautionList = precautionHandler.precautionEntityListToStringList(houseEntity.getPrecautionList());
        List<String> images = imageHandler.exactFilePath(houseEntity.getHouseImageList());

        ViewDetailHouseResDTO viewDetailHouseResDTO = ViewDetailHouseResDTO.builder()
                .houseId(houseEntity.getHouseId())
                .userId(houseEntity.getUser().getUserId())
                .houseInfoDTO(houseInfoDTO)
                .houseAmenityDTO(houseAmenityDTO)
                .houseName(houseEntity.getHouseName())
                .houseIntroduction(houseEntity.getHouseIntroduction())
                .precautionList(precautionList)
                .address(houseEntity.getAddress())
                .region(houseEntity.getRegion())
                .imagePaths(images)
                .build();

        return viewDetailHouseResDTO;
    }
}
