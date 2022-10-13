package com.YourHouseMyHouse.SwitchHouse.service;

import com.YourHouseMyHouse.SwitchHouse.common.mapper.UserMapper;
import com.YourHouseMyHouse.SwitchHouse.dto.request.CreateUserDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.response.ViewMyNoticeImageResDTO;
import com.YourHouseMyHouse.SwitchHouse.dto.response.ViewMyNoticeResDTO;
import com.YourHouseMyHouse.SwitchHouse.entity.AlarmEntity;
import com.YourHouseMyHouse.SwitchHouse.entity.HouseEntity;
import com.YourHouseMyHouse.SwitchHouse.entity.UserEntity;
import com.YourHouseMyHouse.SwitchHouse.repository.AlarmRepository;
import com.YourHouseMyHouse.SwitchHouse.repository.HouseRepository;
import com.YourHouseMyHouse.SwitchHouse.repository.UserRepository;
import com.YourHouseMyHouse.SwitchHouse.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AlarmRepository alarmRepository;
    private final HouseRepository houseRepository;

    @Override
    public void createUser(CreateUserDTO createUserDTO) {
        UserEntity user = UserMapper.INSTANCE.toEntity(createUserDTO);

        userRepository.save(user);
    }

    @Override
    public List<ViewMyNoticeResDTO> viewMyNotice(Long userId) {

        List<AlarmEntity> alarmEntityList = alarmRepository.findAllByReceiver(userId);
        
        //receiverId 가 userId인 AlaramList를 다 들고 온다

        List<ViewMyNoticeResDTO> viewMyNoticeResDTOList = new ArrayList<>();

        for(AlarmEntity alarm : alarmEntityList) {
            HouseEntity houseEntity = houseRepository.findByUserIdWithImage(alarm.getSender().getUserId());

            ViewMyNoticeImageResDTO viewMyNoticeImageResDTO = ViewMyNoticeImageResDTO.builder()
                    .houseName(houseEntity.getHouseName())
                    .startDate(alarm.getStartDate())
                    .endDate(alarm.getEndDate())
                    .filePath(houseEntity.getHouseImageList().get(0).getFilePath())
                    .messageLink(houseEntity.getMessageLink())
                    .build();

            ViewMyNoticeResDTO viewMyNoticeResDTO = ViewMyNoticeResDTO.builder()
                    .alarmStatus(alarm.getAlarmStatus())
                    .userName(houseEntity.getUser().getNickName())
                    .viewMyNoticeImageResDTO(viewMyNoticeImageResDTO)
                    .build();

            viewMyNoticeResDTOList.add(viewMyNoticeResDTO);
        }

        return viewMyNoticeResDTOList;
    }
}
