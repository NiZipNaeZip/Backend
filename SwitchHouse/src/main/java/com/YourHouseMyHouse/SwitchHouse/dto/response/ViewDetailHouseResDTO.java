package com.YourHouseMyHouse.SwitchHouse.dto.response;

import com.YourHouseMyHouse.SwitchHouse.dto.HouseInfoDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.request.AddressDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.request.HouseAmenityDTO;
import lombok.*;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ViewDetailHouseResDTO {

    private Long houseId;
    private Long userId;

    private HouseInfoDTO houseInfoDTO;
    private HouseAmenityDTO houseAmenityDTO;

    private String houseName;
    private String houseIntroduction;
    private List<String> precautionList;

    private String address;
    private String region;

    private List<String> imagePaths;

}
