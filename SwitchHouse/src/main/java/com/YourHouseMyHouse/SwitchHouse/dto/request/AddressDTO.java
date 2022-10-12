package com.YourHouseMyHouse.SwitchHouse.dto.request;

import lombok.*;

import javax.persistence.Column;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {
    private Long postalCode;
    private String address;
    private String detailedAddress;

}
