package donn.springboot_doc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

//@Configuration
@ConfigurationProperties
//@Component
public class MyConfigEnv {
//	  @Value("${customer.env}")
//	  private String env;
	public static String env;

//	  @Value("${name}")
//	  private String name;
//	  
//	  
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

//	public String getEnv() {
//		return env;
//	}
//
//	public void setEnv(String env) {
//		this.env = env;
//	}
	
	@Bean
	  public static Boolean setenv(Environment environment) {
		env = environment.getProperty("customer.env");
		
		return true;
	  }
}
