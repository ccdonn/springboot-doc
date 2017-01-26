package donn.springboot_doc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import donn.springboot_doc.filter.Sample2Filter;
import donn.springboot_doc.filter.SampleFilter;

@Configuration
public class FilterConfig {
	@Bean
	public FilterRegistrationBean registerSample(SampleFilter filter) {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(new SampleFilter());
	    registration.setOrder(1);
	    return registration;
	}
	
	@Bean
	public FilterRegistrationBean registerSample2(SampleFilter filter) {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(new Sample2Filter());
	    registration.setOrder(2);
	    return registration;
	}
}
