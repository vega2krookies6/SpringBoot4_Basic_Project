package com.rookies6.myspringboot4project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySpringBoot4ProjectApplication {

	public static void main(String[] args) {
        //SpringApplication.run(MySpringBoot4ProjectApplication.class, args);
        SpringApplication application = new SpringApplication(MySpringBoot4ProjectApplication.class);

        application.run(args);
    }

    @Bean
    public String myBean() {
        return "Hello Bean";
    }
}
