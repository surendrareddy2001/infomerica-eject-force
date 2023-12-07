package com.infomerica.infomericaejectforce.Controller;


import javax.websocket.server.PathParam;

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
	
	
	@GetMapping("/registeration")
	public String getUserRegistration() {
		return "registration";
	}
//	http://localhost:8080/register?email=suriboreddy2001%40gmail.com&username=Naruto&phonenumber=9603555879&password=Suri2001%40%23%24&fullname=Surendra+Reddy
	@GetMapping("/register")
	public String userRegistration(@PathParam(value = "email") String email,@PathParam(value = "username") String username,@PathParam(value = "phonenumber") Long phonenumber,@PathParam(value = "password") String password,@PathParam(value = "fullname") String fullname ) {
		logger.info("Entered into Usercontroller");
		UserDAO user_obj = new UserDAO(username,password,fullname,phonenumber,email);
		obj.saveUserDetails(user_obj);
		logger.info("Exited from Usercontroller");
		return "LoginPage";
		
	}

	
}
