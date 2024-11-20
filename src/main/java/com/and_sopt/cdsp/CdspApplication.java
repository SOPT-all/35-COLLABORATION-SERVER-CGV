package com.and_sopt.cdsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //AuditingEntityListener 실행하기 위해서 추가
@SpringBootApplication
public class CdspApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdspApplication.class, args);
	}

}
