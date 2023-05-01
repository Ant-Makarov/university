package com.botscrew.task.Test.task;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.time.Clock;
import java.util.Scanner;
import jakarta.inject.Provider;

@SpringBootApplication
@RequiredArgsConstructor
public class TestTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTaskApplication.class, args);
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public Clock clock() {
		return Clock.systemDefaultZone();
	}

	@Bean
	@Scope("prototype")
	public StringBuilder stringBuilder() {
		return new StringBuilder();
	}

	@Bean
	public Provider<StringBuilder> stringBuilderProvider() {
		return new Provider<StringBuilder>() {
			@Autowired
			private ObjectProvider<StringBuilder> objectProvider;

			@Override
			public StringBuilder get() {
				return objectProvider.getObject();
			}
		};
	}
}
