package donn.springboot_doc.repository.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class SampleRedisRepository {
	private StringRedisTemplate template;
	
	@Autowired
	public SampleRedisRepository(StringRedisTemplate template) {
		this.template = template;
	}
	
	public void saveSample(String input) {
		template.opsForValue().set("mySampleKey", input, 1, TimeUnit.MINUTES);
	}
	
	public String getSample() {
		return template.opsForValue().get("mySampleKey");
	}
}
