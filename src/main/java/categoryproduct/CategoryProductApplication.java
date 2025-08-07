package categoryproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"Controller", "Service", "Model"})
@SpringBootApplication
public class CategoryProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryProductApplication.class, args);
	}

}
