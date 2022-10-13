package com.YourHouseMyHouse.SwitchHouse.dto.response;

import com.YourHouseMyHouse.SwitchHouse.dto.HouseInfoDTO;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ViewRegionHouseResDTO {
    private Long houseId;
    private HouseInfoDTO houseInfoDTO;
    private String houseName;
    private String address;
    private String filePath;
}
