package com.infomerica.infomericaejectforce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.infomerica.infomericaejectforce.Services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/upload")
	public String excelToDB(@RequestParam("file") MultipartFile file) {

		employeeService.saveEmployeeDetails(file);
		return "Exited";
	}

}
