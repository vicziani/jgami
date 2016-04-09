package jgami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

@SpringBootApplication
// https://emmersberger.org/java-8-time-api-hibernate-and-spring-data-jpa/
@EntityScan(basePackages = {"jgami", "org.springframework.data.jpa.convert.threeten"})
public class BadgesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BadgesApplication.class, args);
	}
}
