package com.infomerica.infomericaejectforce.Controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infomerica.infomericaejectforce.Services.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	static Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/")
	public String login() {
		return "LoginPage";

	}

//	http://localhost:8080/infomerica/login?email=suriboreddy2001%40gmail.com&password=SA2001%40%23%24 
	@GetMapping("/login")
	public String login(@PathParam(value = "email") String email, @PathParam(value = "password") String password) {
		logger.info("Entered into login page");
		if (loginService.validatePassword(email, password)) {
			logger.info("login successful");
			return "employee";
		} else {
			logger.info("login failed");
			return "errorpage";
		}
	}
//
//        @GetMapping("/login/google")
//        public String googleLogin() {
//            return "redirect:/oauth2/authorization/google";
//        }
//
//        @GetMapping("/login/google/callback")
//        public String googleCallback(@AuthenticationPrincipal OAuth2User principal) {
//           
//        	UserDAO userDetails = loginService.processOAuthUser(principal);
//
//           
//            loginService.save(userDetails);
//
//            return "redirect:/welcome"; 
//        }

}
