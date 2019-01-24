package adobe.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootappApplication.class, args);
		//this will run tomcat and restful services and need not write an app initializer, this will register dispatcher servlet
		//Entity manager factory need not be done here
		//enable content neg handler , component scan is also not required. This will be root folder.
		//driver user name pwd for db is required
	}

}

