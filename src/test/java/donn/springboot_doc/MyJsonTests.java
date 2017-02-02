package donn.springboot_doc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import donn.springboot_doc.request.SampleRequest;
import donn.springboot_doc.response.SampleResponse;

import static org.assertj.core.api.Assertions.*;

//@RunWith(SpringRunner.class)
//@JsonTest
public class MyJsonTests {
	@Autowired
    private JacksonTester<SampleResponse> json;

//    @Test
    public void testSerialize() throws Exception {
    	SampleRequest sample = new SampleRequest();
    	sample.setSid(1234);
    	sample.setSinfo("sinfoo");
    	sample.setSname("snamee");
    	
    	SampleResponse details = new SampleResponse(sample);
        // Assert against a `.json` file in the same package as the test
        assertThat(this.json.write(details)).isEqualToJson("expected.json");
        // Or use JSON path based assertions
        assertThat(this.json.write(details)).hasJsonPathStringValue("@.make");
        assertThat(this.json.write(details)).extractingJsonPathStringValue("@.make")
                .isEqualTo("Honda");
    }

//    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"make\":\"Ford\",\"model\":\"Focus\"}";
    	SampleRequest sample = new SampleRequest();
    	sample.setSid(1234);
    	sample.setSinfo("ford");
    	sample.setSname("focus");
        
        assertThat(this.json.parse(content))
                .isEqualTo(new SampleResponse(sample));
        assertThat(this.json.parseObject(content).getName()).isEqualTo("ford");
    }
}
