package com.YourHouseMyHouse.SwitchHouse;

import com.YourHouseMyHouse.SwitchHouse.common.config.FileUploadProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties({
		FileUploadProperties.class
})
@EnableWebMvc
public class SwitchHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwitchHouseApplication.class, args);
	}

}
