package com.infomerica.infomericaejectforce.Controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.infomerica.infomericaejectforce.DAO.Employee;
import com.infomerica.infomericaejectforce.Services.EmployeeService;

/**
 * Employee Controller
 */
@Controller
public class EmployeeController {

	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	/**
	 * @return
	 */
	@GetMapping("/employee")
	public String getHomePage() {
		logger.info("Calling Employee Page at :{}", LocalDateTime.now());
		return "employee";
	}

	/**
	 * @param file
	 * @return
	 */
	@PostMapping("/upload")
	public void excelToDB(@RequestParam("file") MultipartFile file) {
		logger.info("Calling upload Page at :{}", LocalDateTime.now());
		try {
			String response = employeeService.saveEmployeeDetails(file);
			if (!response.isEmpty() || !response.isBlank())
				logger.info("upload Page sucessfull");
			else
				logger.info("upload Page Failed");
		} catch (Exception e) {

		}
	}

	/**
	 * @param employeeId
	 * @param model
	 * @return
	 */
	@GetMapping("/empbyid")
	public String getEmployeeById(@PathParam(value = "employeeId") int employeeId, Model model) {
		logger.info("Calling Employees By Id Page at :{}", LocalDateTime.now());
		model.addAttribute("employeeData", employeeService.getEmployeeById(employeeId));
		return "employees";
	}

	/**
	 * @param m
	 * @return
	 */
	@GetMapping("/allemployee")
	public String getAllEmployees(Model m) {
		logger.info("Calling all Employees Page at :{}", LocalDateTime.now());
		List<Employee> employees = employeeService.getAllEmployees();
		m.addAttribute("employeeData", employees);
		return "employees";
	}

}
