package donn.springboot_doc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import donn.springboot_doc.service.SampleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
	@MockBean
    private SampleService sampleService;

//    @Autowired
//    private Reverser reverser;

    @Test
    public void exampleTest1() {
        // RemoteService has been injected into the reverser bean
        given(this.sampleService.call()).willReturn("mock");
//        String reverse = reverser.reverseSomeCall();
//        assertThat(reverse).isEqualTo("kcom");
    }
    

    @Test
    public void exampleTest2() {
        // RemoteService has been injected into the reverser bean
        given(this.sampleService.call()).willReturn("sample2-service");
//        String reverse = reverser.reverseSomeCall();
//        assertThat(reverse).isEqualTo("kcom");
    }
    //    
}
