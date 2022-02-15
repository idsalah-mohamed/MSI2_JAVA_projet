package sid.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"sid.usermanagement"})
public class UserGestion {

	public static void main(String[] args) {
		SpringApplication.run(UserGestion.class, args);
	}

}
