package com.infomerica.infomericaejectforce.Controller;

import java.time.LocalDateTime;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.infomerica.infomericaejectforce.DAO.User;
import com.infomerica.infomericaejectforce.Services.LoginService;

/**
 * Login and Registration Controller
 * 
 */
@Controller
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;

	
	/**
	 * @return
	 */
	@GetMapping("/registeration")
	public String getUserRegistration() {
		return "registration";
	}
	
	/**
	 * @param email
	 * @param username
	 * @param phonenumber
	 * @param password
	 * @param fullname
	 * @return
	 */
	@GetMapping("/register")
	public String userRegistration(@PathParam(value = "email") String email,@PathParam(value = "username") String username,@PathParam(value = "phonenumber") Long phonenumber,@PathParam(value = "password") String password,@PathParam(value = "fullname") String fullname ) {
		logger.info("Entered into Usercontroller");
		
		User user = new User(username,password,fullname,phonenumber,email);
		loginService.saveUserDetails(user);
		logger.info("Exited from Usercontroller :{}",LocalDateTime.now());
		return "LoginPage";
		
	}

	/**
	 * @return
	 */
	@GetMapping("/")
	public String login() {
		return "LoginPage";

	}
	
	/**
	 * @param email
	 * @param password
	 * @return
	 */
	@GetMapping("/login")
	public String login(@PathParam(value = "email") String email, @PathParam(value = "password") String password) {
		
		logger.info("Entered into login page:{}", LocalDateTime.now());
		
		if (loginService.validatePassword(email, password)) 
		{
			logger.info("login successful for : {}",email);
			return "employee";
		} else {
			logger.info("login failed for : {}",email);
			return "errorpage";
		}
	}

}
