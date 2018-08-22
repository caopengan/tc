package com.simba.tc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.simba.*")//指定要扫描的包
@EnableJpaRepositories(basePackages="com.simba.*")
@EntityScan(basePackages="com.simba.*")
public class TcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcApplication.class, args);
	}
}