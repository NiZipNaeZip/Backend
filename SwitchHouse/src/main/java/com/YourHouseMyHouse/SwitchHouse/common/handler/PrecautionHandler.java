package com.YourHouseMyHouse.SwitchHouse.common.handler;

import com.YourHouseMyHouse.SwitchHouse.entity.PrecautionEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrecautionHandler {

    public List<String> precautionEntityListToStringList(List<PrecautionEntity> precautionEntityList) {
        List<String> stringList = new ArrayList<>();

        for(PrecautionEntity precaution : precautionEntityList) {
            stringList.add(precaution.getComment());
        }

        return stringList;
    }
}
