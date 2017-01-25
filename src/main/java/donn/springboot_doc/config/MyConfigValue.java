package donn.springboot_doc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Configuration
@Component
public class MyConfigValue {
//	  @Value("${customer.env}")
//	  private String env;
//	public static String env;

	  @Value("${name}")
	  private String name;
	  
	  
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getEnv() {
//		return env;
//	}
//
//	public void setEnv(String env) {
//		this.env = env;
//	}
	
//	@Bean
//	  public static Boolean setenv(Environment environment) {
//		env = environment.getProperty("customer.env");
//		
//		return true;
//	  }
}
