package com.arunbalachandran.loginapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@SpringBootApplication
public class LoginapiApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LoginapiApplication.class, args);
	}

}
