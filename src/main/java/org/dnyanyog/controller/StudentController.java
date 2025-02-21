package org.dnyanyog.controller;

import org.dnyanyog.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
public class StudentController {
	@Autowired
	Student std;

	@GetMapping(path = "/student", produces = {"application/json","application/json"})
	public Student getStudent() {
		
		std.setFirstName("Manthan");
		std.setLastName("Shevlkar");
		std.setEmail("manthan@gmail.com");
		std.setMobile("7385368623");
		std.setAge("19");
		
		return std;
	
	}
	@PostMapping(path = "/student",produces = {"application/json","application/xml"}, consumes = {"application/json","application/xml"})
	public String saveStudentData(@RequestBody Student std) {
		
		System.out.println(std.getFirstName());
		System.out.println(std.getLastName());
		System.out.println(std.getEmail());
		System.out.println(std.getMobile());
		System.out.println(std.getAge());
		
		return "Data saved";
		
	}
}