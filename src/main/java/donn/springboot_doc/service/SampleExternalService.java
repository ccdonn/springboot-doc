package donn.springboot_doc.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SampleExternalService {

	public String call() {
		// https://api.foursquare.com/v2/venues/4b697366f964a520d5a22be3?client_id=ZNHR3G2DJOBKUAA2POZQGFFID0VKTLW3ZALKB4BK2OI50ZIC&client_secret=L5JEDBOFHIADQI1ZRRKL3G13GXFK2PWMMVRUILUOYSVJF41M&v=20170101
		RestTemplate rt = new RestTemplate();
		Object o = rt.getForObject("https://api.foursquare.com/v2/venues/4b697366f964a520d5a22be3?client_id=ZNHR3G2DJOBKUAA2POZQGFFID0VKTLW3ZALKB4BK2OI50ZIC&client_secret=L5JEDBOFHIADQI1ZRRKL3G13GXFK2PWMMVRUILUOYSVJF41M&v=20170101", Object.class);
		System.out.println(o);
		
		return "external";
	}
	

}
