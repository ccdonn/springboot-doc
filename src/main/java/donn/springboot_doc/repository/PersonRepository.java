package donn.springboot_doc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import donn.springboot_doc.entity.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{
	
}
