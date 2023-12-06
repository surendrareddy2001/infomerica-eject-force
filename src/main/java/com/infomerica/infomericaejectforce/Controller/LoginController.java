package com.infomerica.infomericaejectforce.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infomerica.infomericaejectforce.Services.LoginService;

@RestController
@RequestMapping("/api/users")
public class LoginController {

    
	private LoginService loginService;
	static Logger logger = LoggerFactory.getLogger(UserController.class);
	

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

   // @GetMapping("/login/{username}/{password}")
    @GetMapping("/login")
    	public String login(@ModelAttribute String username, @ModelAttribute String password) {
    	logger.info("Entered into login page");
        if (loginService.validatePassword(username, password)) {
        	logger.info("login successful");
            return "welcomepage";
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

