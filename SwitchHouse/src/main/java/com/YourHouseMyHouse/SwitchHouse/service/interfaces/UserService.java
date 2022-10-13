package com.YourHouseMyHouse.SwitchHouse.service.interfaces;

import com.YourHouseMyHouse.SwitchHouse.dto.request.CreateUserDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.response.ViewMyNoticeResDTO;

import java.util.List;

public interface UserService {
    void createUser(CreateUserDTO createUserDTO);
    List<ViewMyNoticeResDTO> viewMyNotice (Long userId);
}
