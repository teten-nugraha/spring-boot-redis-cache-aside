package id.ten.app.democacheaside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoCacheAsideApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCacheAsideApplication.class, args);
	}

}
