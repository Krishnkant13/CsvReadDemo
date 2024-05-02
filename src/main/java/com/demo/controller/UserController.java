package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.CsvToObject;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private CsvToObject csvtoobject;
	
	@GetMapping("/printdata")
	public void printData() {
		csvtoobject.printUser();
	}

}
