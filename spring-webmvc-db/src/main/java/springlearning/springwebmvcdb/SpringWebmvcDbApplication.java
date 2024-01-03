package springlearning.springwebmvcdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "springlearning.springwebmvcdb") // 하위 컴포넌트를 찾도록 하는 어노테이션
public class SpringWebmvcDbApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringWebmvcDbApplication.class, args);
	}

}
