package com.YourHouseMyHouse.SwitchHouse.dto.response;

import com.YourHouseMyHouse.SwitchHouse.common.entity.AlarmStatus;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ViewMyNoticeResDTO {

    private AlarmStatus alarmStatus;
    private String userName;

    private ViewMyNoticeImageResDTO viewMyNoticeImageResDTO;
}
