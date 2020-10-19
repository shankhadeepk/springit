package com.shank.springit;

import com.shank.springit.config.SpringItProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(SpringItProp.class)
public class SpringitApplication {

	@Autowired
	public SpringItProp springItProp;

	@Autowired
	public ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);

		System.out.println("Hello Spring boot");
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			System.out.println("Welcome message is:"+springItProp.getWelcomeMsg());
		};
	}

	@Bean
	@Profile("dev")
	CommandLineRunner runnerDev(){
		return args -> {
			System.out.println("Will work for DEV environment");
		};
	}

	/*@Bean
	CommandLineRunner lineRunner(){
		return args -> {
			System.out.println("printing out all bean names in application context");
			System.out.println("--------------------------------------------------");
			String[] beans=applicationContext.getBeanDefinitionNames();
			Arrays.sort(beans);
			for (String bean:beans){
				System.out.println(bean);
			}
		};
	}*/

}
