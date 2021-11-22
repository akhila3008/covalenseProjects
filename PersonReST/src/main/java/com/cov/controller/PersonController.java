
package com.cov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cov.beans.Person;
import com.cov.exception.InvalidPersonIdException;
import com.cov.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;

	
	@GetMapping("/{id}")
	public Person find(@PathVariable int id) throws InvalidPersonIdException {
		System.out.println("data not found"+id);
		return personService.findById(id);

	}


	@GetMapping()
	public List<Person> findAll() {
		System.out.println("data not found");
		return personService.findAll();

	}

	
	@PostMapping()
	public Person insertPerson(@RequestBody Person person) {
		System.out.println("data not found"+person);
		return personService.insert(person);

	}

	
	@PutMapping()
	public Person edit(@RequestBody Person person) throws InvalidPersonIdException {
		System.out.println("data not found"+person);
		return personService.update(person);
	}

	
	@DeleteMapping("/{id}")
	public Person delete(@PathVariable int id) throws InvalidPersonIdException {
		System.out.println("data not found"+id);
		return personService.delete(id);
	}

}
