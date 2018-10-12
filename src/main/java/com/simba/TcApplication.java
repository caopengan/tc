package com.simba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ComponentScan(basePackages="com.simba.*")//指定要扫描的包
//@EnableJpaRepositories(basePackages="com.simba.*")
//@EntityScan(basePackages="com.simba.*")
//@EnableElasticsearchRepositories(basePackages = "com.simba.es.*")
public class TcApplication {


	public static void main(String[] args) {
		//redis和elaticsearch冲突的解决办法
		System.setProperty("es.set.netty.runtime.available.processors", "false");
		SpringApplication.run(TcApplication.class, args);
	}

//	@PostConstruct
//	public void task() {
//		spiderHandler.spiderData();
//	}
}
