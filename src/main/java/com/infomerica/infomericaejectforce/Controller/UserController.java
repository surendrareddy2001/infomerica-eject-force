package com.infomerica.infomericaejectforce.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.infomerica.infomericaejectforce.DAO.UserDAO;
import com.infomerica.infomericaejectforce.DTO.User;
import com.infomerica.infomericaejectforce.Services.UserDaoService;





@Controller
public class UserController {
	@Autowired
	UserDaoService obj;
	static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@GetMapping("/")
	public String getUserRegistration() {
		return "registration";
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> userRegistration(@ModelAttribute UserDAO user_obj) {
		logger.info("Entered into Usercontroller");
		User registrationResponse = obj.saveUserDetails(user_obj);
		logger.info("Exited from Usercontroller");
		return ResponseEntity.ok(registrationResponse);
		
	}

	
}
