package donn.springboot_doc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import donn.springboot_doc.controller.SampleController;
import donn.springboot_doc.entity.Person;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class MyControllerTests {

	@Autowired
    private MockMvc mvc;

    @MockBean
	private SampleController sampleController;

    
    @Test
    public void testExample() throws Exception {
    	
    	given(this.sampleController.get1Person())
                .willReturn(new Person("donn666"));
    	
        this.mvc.perform(get("/db1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"donn777\"}"));
    }
    

}
