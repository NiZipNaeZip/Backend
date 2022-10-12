package com.YourHouseMyHouse.SwitchHouse.common.mapper.custom;

import com.YourHouseMyHouse.SwitchHouse.entity.PrecautionEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomPrecautionMapper {

    public PrecautionEntity stringToPrecautionEntity(String comment) {
        PrecautionEntity precaution = PrecautionEntity.builder()
                .comment(comment)
                .build();

        return precaution;
    }
}
