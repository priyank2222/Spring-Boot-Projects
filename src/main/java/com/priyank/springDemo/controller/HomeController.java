package com.priyank.springDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/upload")
	public String registration() {
		
		String str3="<html><h2>Registration form</h2>"
				+ "<form method= 'POST' action='/api/upload' enctype='multipart/form-data'>"
				+ "<input type='file' name='myFile' id='myFile'><br><br>"
				+ "<button type='submit'>submit</button> </form></html>";
		return str3;
		
	}
}
