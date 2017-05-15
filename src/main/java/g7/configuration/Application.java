package g7.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
@SpringBootApplication(scanBasePackages = {"g7"})
//@ComponentScan({ "configuration", "controller", "dao", "exception", "inf", "model", "service", "util" })
@ComponentScan(basePackages = "g7")
@PropertySource(value = { "classpath:application.properties" })
public class Application extends SpringBootServletInitializer {
	static String RESOURCES_DIR;
	public static void main(String[] args) {
		RESOURCES_DIR = "/resources/";
		SpringApplication.run(Application.class, args);
	}
	 @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
