package edu.vnrvjiet.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentMarkServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMarkServiceApplication.class, args);
        System.out.println("Tomcat running for Student Mark Microservice... Testing");
	}
}