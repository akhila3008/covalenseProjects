package com.cov.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cov.beans.Person;
import com.cov.exception.InvalidPersonIdException;
import com.cov.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person findById(int id) throws InvalidPersonIdException {
		Optional<Person> personOptional = personRepository.findById(id);
		if (!personOptional.isPresent()) {
			throw new InvalidPersonIdException();
		}
		return personOptional.get();
	}

	public Person insert(Person person) {
		return personRepository.save(person);
	}

	public Person update(Person person) throws InvalidPersonIdException {
		Optional<Person> personOptional = personRepository.findById(person.getId());
		if (!personOptional.isPresent()) {
			throw new InvalidPersonIdException();
		}
		return personRepository.save(person);
	}

	public Person delete(int id) throws InvalidPersonIdException {
		Optional<Person> personOptional = personRepository.findById(id);
		if (!personOptional.isPresent()) {
			throw new InvalidPersonIdException();
		}
		Person person = personOptional.get();
		personRepository.deleteById(id);
		return person;
	}
}