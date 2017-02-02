package donn.springboot_doc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import donn.springboot_doc.controller.SampleController;
import donn.springboot_doc.entity.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SampleTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	SampleController sampleController;
	
	@Test
	public void exampleTest1() {
		System.out.println("sample test-1");
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).isEqualTo("hi");
	}
	
//	@Test
	public void exampleTest2() {
		System.out.println("sample test-2");
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).isEqualTo("hello");
	}
	
//	@Test
//	public void exampleTest3() {
//		System.out.println("sample test-3");
//		Person body = this.restTemplate.getForObject("/db1", Person.class);
//		assertThat(body.getName()).isEqualTo(new Person("jjj").getName());
//	}
}
