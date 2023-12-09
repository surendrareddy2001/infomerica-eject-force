package com.infomerica.infomericaejectforce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infomerica.infomericaejectforce.DAO.Employee;

/**
 * EmployeeRepository 
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}