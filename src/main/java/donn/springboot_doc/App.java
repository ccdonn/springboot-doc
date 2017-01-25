package donn.springboot_doc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication

public class App 
{
    public static void main( String[] args )
    {
		SpringApplication.run(App.class, args);
//		System.out.println(MyConfigEnv.env);
//		System.out.println(new MyConfigValue().getName());
    }
}
