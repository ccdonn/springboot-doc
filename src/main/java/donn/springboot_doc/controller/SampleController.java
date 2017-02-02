package donn.springboot_doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import donn.springboot_doc.config.MyConfigEnv;
import donn.springboot_doc.config.MyConfigValue;
import donn.springboot_doc.entity.Person;
import donn.springboot_doc.request.SampleRequest;
import donn.springboot_doc.response.SampleResponse;
import donn.springboot_doc.service.SampleExternalService;
import donn.springboot_doc.service.SampleService;

@RestController
public class SampleController {
	
	@Autowired
	SampleExternalService sampleExternalService;

	@RequestMapping("/external")
	public String external() {
		return sampleExternalService.call();
	}
	
	/**
	 * Env inject by autowired
	 */
	@Autowired
	MyConfigValue myConfig;
	
	@Autowired
	SampleService sampleService;
	
	@RequestMapping("/")
	public String sample() {
		System.out.println(MyConfigEnv.env);
		System.out.println(myConfig.getName());
		return "hi";
	}
	
	@RequestMapping("/sample")
	public String sample2() {
		return sampleService.call();
	}
	

	@RequestMapping(value="/method", method=RequestMethod.GET)
	public String getSample(
			@RequestParam(value="name", defaultValue="World") String name) {
		System.out.println("Hello, " + name);
		return "get";
	}
	
	@RequestMapping(value="/method", method=RequestMethod.POST)
	public SampleRequest postSample(@RequestBody SampleRequest sreq) {
		System.out.println(sreq.getSid());
		System.out.println(sreq.getSname());
		System.out.println(sreq.getSinfo());
//		return "post";
		return sreq;
	}
	
	@RequestMapping(value="/method/{id}", method=RequestMethod.PUT)
	public SampleResponse putSample(
			@PathVariable("id") String id,
			@RequestParam(value="lang", defaultValue="en") String lang,
			@RequestBody SampleRequest sreq) {
		System.out.println(id);
		System.out.println(lang);
		System.out.println(sreq.getSid());
		System.out.println(sreq.getSname());
		System.out.println(sreq.getSinfo());
		return new SampleResponse(sreq);
	}
	
	@RequestMapping(value="/method/{id}", method=RequestMethod.DELETE)
	public String deleteSample(@PathVariable("id") String id) {
		return "delete";
	}
	
	@RequestMapping(value="/upload")
	public String uploadfile(@RequestParam("img") MultipartFile file) {
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getOriginalFilename());

		return "finish";
	}
	
	@RequestMapping(value="/db")
	public Iterable<Person> getPerson() {
		return sampleService.getPerson();
	}
	
	@RequestMapping(value="/db1")
	public Person get1Person() {
		return sampleService.get1Person(7);
	}
	
	@RequestMapping(value="/db", method=RequestMethod.POST)
	public Person savePerson() throws Exception {
//		throw new Exception();
		return sampleService.savePerson(new Person("donn"));
	}
	
	@RequestMapping(value="/redis", method=RequestMethod.GET)
	public String getRedis() {
		return sampleService.getRedis();
	}
	
	@RequestMapping(value="/redis", method=RequestMethod.POST)
	public String postRedis() {
		sampleService.postRedis();
		return "ok";
	}
}
