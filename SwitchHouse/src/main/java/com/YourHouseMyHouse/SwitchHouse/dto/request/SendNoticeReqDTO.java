package com.YourHouseMyHouse.SwitchHouse.dto.request;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SendNoticeReqDTO {
    String startDate;
    String endDate;
    Long senderId;
    Long receiverId;
}
