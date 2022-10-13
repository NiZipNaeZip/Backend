package com.YourHouseMyHouse.SwitchHouse.controller;

import com.YourHouseMyHouse.SwitchHouse.dto.request.CreateUserDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.response.ViewMyNoticeResDTO;
import com.YourHouseMyHouse.SwitchHouse.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 사용자 생성
     * @param createUserDTO
     * @return HttpStatusCode
     */
    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDTO createUserDTO) {
        
        userService.createUser(createUserDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/notice")
    public ResponseEntity<List<ViewMyNoticeResDTO>> viewMyNotice(@PathVariable Long userId) {
        List<ViewMyNoticeResDTO> viewMyNoticeResDTOList = userService.viewMyNotice(userId);

        return new ResponseEntity<>(viewMyNoticeResDTOList, HttpStatus.OK);
    }
}
