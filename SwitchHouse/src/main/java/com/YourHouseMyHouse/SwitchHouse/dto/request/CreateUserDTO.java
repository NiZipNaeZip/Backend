package com.YourHouseMyHouse.SwitchHouse.dto.request;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateUserDTO {
    
    private String loginId;
    private String password;
    private String nickName;
    
    //주소 부분
    private Long postalCode;
    private String address;
    private String detailedAddress;
    
    //인증
    private Boolean certified;
    
    //카카오톡 링크
    private String messageLink;
    
    //자기 소개
    private String introduction;

    //지역
    private String region;
}
