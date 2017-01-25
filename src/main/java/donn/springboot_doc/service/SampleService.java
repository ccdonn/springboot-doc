package donn.springboot_doc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import donn.springboot_doc.entity.Person;
import donn.springboot_doc.repository.PersonRepository;

@Service
@Transactional
public class SampleService {

	public String call() {
		return "sample2-service";
	}

	@Autowired
	PersonRepository personRepository;
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Iterable<Person> getPerson() {
		return personRepository.findAll();	
	}
	
	@Transactional(rollbackFor=Exception.class)
	public Person savePerson(Person person) throws Exception {
		// Normal
//		return personRepository.save(person);
		// Exception, Transaction work?
		Person newPerson = personRepository.save(person);
		
		if (newPerson != null) {
//			return newPerson;
//			throw new RuntimeException();
			throw new Exception();
		} else {
			throw new Exception();
		}
	}

}
