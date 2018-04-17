package com.scu.zdhzzz.gd;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GdApplication {

	@RequestMapping("/")
	String index(){

		return "hello spring boot";
	}
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(GdApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
