package com.spring.batch.demo;

import org.springframework.boot.SpringApplication;

public class SimpleJobLauncher {
	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(BatchConfiguration.class, args)));
	}
}
