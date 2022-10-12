package com.YourHouseMyHouse.SwitchHouse.service;

import com.YourHouseMyHouse.SwitchHouse.common.mapper.UserMapper;
import com.YourHouseMyHouse.SwitchHouse.dto.request.CreateUserDTO;
import com.YourHouseMyHouse.SwitchHouse.entity.UserEntity;
import com.YourHouseMyHouse.SwitchHouse.repository.UserRepository;
import com.YourHouseMyHouse.SwitchHouse.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(CreateUserDTO createUserDTO) {
        UserEntity user = UserMapper.INSTANCE.toEntity(createUserDTO);

        userRepository.save(user);
    }
}
