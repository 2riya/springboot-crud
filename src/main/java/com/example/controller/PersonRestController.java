package com.example.controller;

import java.util.List;

import com.example.model.Person;
import com.example.service.IPersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/person/api/v1")
public class PersonRestController {

	@Autowired
	private IPersonService personService;

	@GetMapping(value = "/people")
	public ResponseEntity<List<Person>> people() {
		List<Person> list = personService.listPerson();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/search/{name}")
	public ResponseEntity<List<Person>> search(
			@PathVariable(name = "name", required = true) String name) {
		List<Person> list = personService.search(name);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
