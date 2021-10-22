package dorres.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch05Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Ch05Application.class);
		//스프링 애플리케이션을 실행할 때 WebApplicationType을 NONE으로 설정했기 때문에 내장 톰캣을 구동하지 않고 실행함
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

}
