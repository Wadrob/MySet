package com.github.wadrob.myset;

import com.github.wadrob.myset.web.converters.TagConverter;
import com.github.wadrob.myset.web.converters.UserConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MysetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysetApplication.class, args);
	}

	@Bean
	public TagConverter getTagConverter() {
		return new TagConverter();
	}

	@Bean
	public UserConverter getUserConverter(){
		return new UserConverter();
	}

}
