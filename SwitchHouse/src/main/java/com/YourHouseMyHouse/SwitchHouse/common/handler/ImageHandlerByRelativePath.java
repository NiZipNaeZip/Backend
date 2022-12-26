package com.YourHouseMyHouse.SwitchHouse.common.handler;

import com.YourHouseMyHouse.SwitchHouse.common.handler.interfaces.ImageHandler;
import com.YourHouseMyHouse.SwitchHouse.entity.HouseEntity;
import com.YourHouseMyHouse.SwitchHouse.entity.HouseImageEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImageHandlerByRelativePath implements ImageHandler {

    @Override
    public List<HouseImageEntity> parseFileInfoImage(List<MultipartFile> multipartFiles) throws IOException, IllegalStateException {
        // 반환할 파일 리스트
        List<HouseImageEntity> houseImageEntityList = new ArrayList<>();

        // 전달되어 온 파일이 존재할 경우
        if (!CollectionUtils.isEmpty(multipartFiles)) {
            // 파일명을 업로드 한 날짜로 변환하여 저장
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd");
            String current_date = now.format(dateTimeFormatter);

            // 프로젝트 디렉터리 내의 저장을 위한 절대 경로 설정
            // 경로 구분자 File.separator 사용
            // String absolutePath = new File("").getAbsolutePath() + File.separator + File.separator;
            //String absolutePath = new File("").getAbsolutePath() + File.separator;
            String absolutePath = new File("").getAbsolutePath() + File.separator;

            // 파일을 저장할 세부 경로 지정
            //String path = "src" + File.separator + "main" + File.separator + "resources" + File.separator +"images" + File.separator + "BoardAttach" + File.separator + current_date;
            //String path = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static";
            String path = File.separator + "home" + File.separator + "ec2-user" + File.separator + "Backend" + File.separator + "images" + File.separator + "static";
            File file = new File(path);

            // 디렉터리가 존재하지 않을 경우
            if (!file.exists()) {
                boolean wasSuccessful = file.mkdirs();

                // 디렉터리 생성에 실패했을 경우
                if (!wasSuccessful)
                    System.out.println("file: was not successful");
            }

            // 다중 파일 처리
            for (MultipartFile multipartFile : multipartFiles) {

                // 파일의 확장자 추출
                String originalFileExtension;
                String contentType = multipartFile.getContentType();

                // 확장자명이 존재하지 않을 경우 처리 x
                if (ObjectUtils.isEmpty(contentType)) {
                    break;
                } else {  // 확장자가 jpeg, png인 파일들만 받아서 처리
                    if (contentType.contains("image/jpeg"))
                        originalFileExtension = ".jpg";
                    else if (contentType.contains("image/png"))
                        originalFileExtension = ".png";
                    else  // 다른 확장자일 경우 처리 x
                        break;
                }

                // 파일명 중복 피하고자 나노초까지 얻어와 지정
                String new_file_name = System.nanoTime() + originalFileExtension;

                // 첨부파일 Entity 생성
                HouseImageEntity houseImage = HouseImageEntity.builder()
                        .fileOriginalName(multipartFile.getOriginalFilename())
                        .fileName(new_file_name)
                        .filePath(path + File.separator + new_file_name)
                        .build();

                // 생성 후 리스트에 추가
                houseImageEntityList.add(houseImage);

                // 업로드 한 파일 데이터를 지정한 파일에 저장
                file = new File(absolutePath + path + File.separator + new_file_name);
                multipartFile.transferTo(file);

                // 파일 권한 설정(쓰기, 읽기)
                file.setWritable(true);
                file.setReadable(true);
            }
        }

        return houseImageEntityList;
    }

    @Override
    public List<String> exactFilePath(List<HouseImageEntity> houseImageEntityList) {
        List<String> stringList = new ArrayList<>();

        for(HouseImageEntity houseImage : houseImageEntityList) {
            stringList.add(houseImage.getFileName());
        }

        return stringList;
    }
}
