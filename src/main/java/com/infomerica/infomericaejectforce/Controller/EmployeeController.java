package com.infomerica.infomericaejectforce.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.infomerica.infomericaejectforce.DAO.EmployeeDAO;
import com.infomerica.infomericaejectforce.Services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employee")
	public String getPage() {
		return "employee";
	}
	
	@PostMapping("/upload")
	public String excelToDB(@RequestParam("file") MultipartFile file) {

		employeeService.saveEmployeeDetails(file);
		return "Exited";
	}
	@GetMapping("/empbyid")
	public String getEmployeeById(@PathParam(value = "employeeId") int employeeId, Model model) {
		model.addAttribute("employeeData", employeeService.getEmployeeById(employeeId));
		return "employees";
	}
	 @GetMapping("/all")
	    public String getAllEmployees(Model m) {
	        List<EmployeeDAO> employees = employeeService.getAllEmployees();
	        m.addAttribute("employeeData", employees);
	        return "employees";
	    }

}
