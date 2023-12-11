package vn.iotstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoSpringbootThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringbootThymeleafApplication.class, args);
	}

}
