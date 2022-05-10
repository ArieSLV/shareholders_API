package com.arie.shareholders.shareholders;

import java.time.LocalDate;
import java.util.List;

import com.arie.shareholders.shareholders.shareholder.Shareholder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ShareholdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareholdersApplication.class, args);
	}



}
