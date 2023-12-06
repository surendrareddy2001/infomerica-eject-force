package com.infomerica.infomericaejectforce.Services;

import com.infomerica.infomericaejectforce.Controller.UserController;
import com.infomerica.infomericaejectforce.DAO.UserDAO;
import com.infomerica.infomericaejectforce.Repository.LoginRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
 
	private LoginRepository loginRepository;
	
	static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;
 
    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public boolean validatePassword(String username, String password) {
        List<UserDAO> users = loginRepository.findAllUsers();
        logger.info("data fetched from database");
        return users.stream()
                .anyMatch(user -> passwordEncoder.matches(password, user.getPassword()));
    }
}
