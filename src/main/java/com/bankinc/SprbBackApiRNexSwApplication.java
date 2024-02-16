package com.bankinc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SprbBackApiRNexSwApplication {

	private static final String dateFomat = "yyyy-MM-dd";
	private static final String dateTimeFomat = "yyyy-MM-dd HH:mm:ss";
	
	public static void main(String[] args) {
		SpringApplication.run(SprbBackApiRNexSwApplication.class, args);
	}
	
	/*@Bean
	public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
		return builder -> {
			builder.simpleDateFormat(dateFormat);
			builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateFormat)));
			builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
		};
	}*/

}
