package com.springboot.app;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			//System.out.println("Inspection of beans provided by the spring boot");
			String[] beans = ctx.getBeanDefinitionNames();
			Arrays.sort(beans);
//			for (String bean : beans) {
//				System.out.println(bean);
//			}
		};
	}

}
