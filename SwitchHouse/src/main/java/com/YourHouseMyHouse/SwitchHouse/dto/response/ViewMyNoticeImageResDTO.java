package com.YourHouseMyHouse.SwitchHouse.dto.response;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ViewMyNoticeImageResDTO {
    private String houseName;
    private String startDate;
    private String endDate;
    private String filePath;
    private String messageLink;
}
