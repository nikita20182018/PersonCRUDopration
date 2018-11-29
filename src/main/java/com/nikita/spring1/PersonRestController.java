package com.nikita.spring1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikita.spring.model.Person;
import com.nikita.spring.service.PersonService;

@RestController
public class PersonRestController {

	@Autowired
	private PersonService personservice;

	/*
	 * @GetMapping("/display") public List displayperson() { return
	 * personservice.displayAll();
	 * 
	 * 
	 * 
	 * }
	 */
	/*@GetMapping("/display")
	public ResponseEntity<List<Person>> displayall() {
		List<Person> plist = personservice.displayAll();
		return ResponseEntity.ok().body(plist);
	}*/
	
	/*@GetMapping("/personbyid/{id}")
	public ResponseEntity  getPerson(@RequestParam int id) {
		Person person=personservice.getpersonById(id);
		return ResponseEntity.ok().body(person);

		
	}*/
	
	
	@GetMapping("/dispaly")
	public void displayall() {
		List<Person> plist = personservice.displayAll();
		 ResponseEntity<List<Person>> r=ResponseEntity.ok().body(plist);
		 System.out.println(r);
//		 consol.log(r);
	}
	
}
