package com.study.boot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement
@SpringBootApplication
public class Boot3Application {

public static void main(String[] args) {
	SpringApplication.run(Boot3Application.class, args);
}

}
