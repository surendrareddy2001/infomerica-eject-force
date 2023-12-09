package com.infomerica.infomericaejectforce.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infomerica.infomericaejectforce.DAO.Employee;
import com.infomerica.infomericaejectforce.Repository.EmployeeRepository;

/**
 * EmployeeService class
 */
@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	/**
	 * @param file 
	 * @return Save the XL data into DB
	 */
	public String saveEmployeeDetails(MultipartFile file) {

		List<Employee> empList = new ArrayList<>();

		try {
			XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowindex = 0;
			for (Row row : sheet) {
				if (rowindex == 0) {
					rowindex++;
					continue;
				}

				Iterator<Cell> it = row.iterator();
				Employee employeeDAO = new Employee();
				while (it.hasNext()) {

					employeeDAO.setEmpid((int) it.next().getNumericCellValue());
					employeeDAO.setEmpname(it.next().getStringCellValue().toLowerCase());
					employeeDAO.setPhnno((long) it.next().getNumericCellValue());
					employeeDAO.setDateofjoining(it.next().getLocalDateTimeCellValue().toLocalDate());
					employeeDAO.setDateofrelieving(it.next().getLocalDateTimeCellValue().toLocalDate());
					employeeDAO.setTechnology(it.next().getStringCellValue());
					employeeDAO.setExperience((int) it.next().getNumericCellValue());
					employeeDAO.setCertifications(it.next().getStringCellValue());
					employeeDAO.setCurrentcompany(it.next().getStringCellValue());
					employeeDAO.setPreviouscompany(it.next().getStringCellValue());
					employeeDAO.setCtc((int) it.next().getNumericCellValue());
					employeeDAO.setQualification(it.next().getStringCellValue());

				}
				empList.add(employeeDAO);
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
		employeeRepository.saveAll(empList);
		return "Sucessesfully Uploaded";

	}

	/**
	 * @param employeeId
	 * @return Single EMployee Data By Employee Id
	 */
	public List<Employee> getEmployeeById(int employeeId) {
		List<Employee> list = Arrays.asList(employeeRepository.findById(employeeId).orElse(null));
		return list;
	}

	/**
	 * @return all Employees
	 */
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

}
