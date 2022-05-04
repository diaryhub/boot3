package com.study.boot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement
@SpringBootApplication
//@EnableScheduling
public class Boot3Application {

public static void main(String[] args) {
	SpringApplication.run(Boot3Application.class, args);
}

}
