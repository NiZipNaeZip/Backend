package com.YourHouseMyHouse.SwitchHouse.common.handler;

import org.mapstruct.ap.shaded.freemarker.template.utility.StringUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ParseTagAddress {

    public String parseTagAddressFromAddress(String address) {
        String[] temp = address.split("\\s+");

        return temp[0];
    }
}
