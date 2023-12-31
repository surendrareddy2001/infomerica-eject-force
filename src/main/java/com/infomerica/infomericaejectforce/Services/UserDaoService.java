package com.infomerica.infomericaejectforce.Services;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.infomerica.infomericaejectforce.Controller.UserController;
import com.infomerica.infomericaejectforce.DAO.UserDAO;
import com.infomerica.infomericaejectforce.DTO.User;
import com.infomerica.infomericaejectforce.Repository.UserRepository;

@Service
public class UserDaoService {

	@Autowired
	UserRepository userRepository;
	static Logger logger = LoggerFactory.getLogger(UserController.class);

	public User saveUserDetails(UserDAO obj) {

		String userName = obj.getUsername();
		String password = obj.getPassword();
		String fullName = obj.getFullname();
		long phoneNumber = obj.getPhonenumber();
		String email = obj.getEmail();
		logger.info("Email used for registration: " + email);
		String errormessage = "null";
		int status = 0;
		boolean flag = true;

		logger.info("Entered into saveUserDetails : {} ", LocalDateTime.now());

		if (!isValidUserName(userName)) {
			errormessage = "UserName should be less than 30 charecters";
			flag = false;
		}

		if (!isValidPassword(password)) {
			errormessage = "Password must contain 4 digits and 2 special charecters";
			flag = false;
		}

		if (!isValidPhoneNumber(phoneNumber)) {
			errormessage = "Phone number must contain 10 digits";
			flag = false;
		}

		if (!isValidEmailFormat(email)) {
			errormessage = "Email is invalid";
			flag = false;
		}

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encryptedPassword = passwordEncoder.encode(password);

		if (flag)
			status = userRepository.insertUserDetails(userName, encryptedPassword, fullName, phoneNumber, email);
	
		User registrationResponse = new User();

		if (status == 1) {
			logger.info("User created");
			registrationResponse.setStatus(HttpStatus.CREATED);
			registrationResponse.setMessage("Sucessfully registered");
			registrationResponse.setErrorcode(errormessage);
			return registrationResponse;
		}

		else {
			logger.info("User creation failed due to " + errormessage);
			registrationResponse.setStatus(HttpStatus.BAD_REQUEST);
			registrationResponse.setMessage("Failed");
			registrationResponse.setErrorcode(errormessage);
			return registrationResponse;
		}

	}

	public boolean isValidPassword(String password) {
		// Check for at least 4 digits
		  Pattern digitPattern = Pattern.compile("\\d");
	        Matcher digitMatcher = digitPattern.matcher(password);
	        int digitCount = 0;
	        while (digitMatcher.find()) {
	            digitCount++;
	        }

	        // Check for at least 2 special characters
	        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
	        Matcher specialCharMatcher = specialCharPattern.matcher(password);
	        int specialCharCount = 0;
	        while (specialCharMatcher.find()) {
	            specialCharCount++;
	        }

	        // Adjust the counts based on your specific rules
	        return digitCount >= 4 && specialCharCount >= 2;
	}

	public static boolean isValidPhoneNumber(long phoneNumber) {

		return Pattern.matches("[0-9]{10}", String.valueOf(phoneNumber));
	}

	public static boolean isValidUserName(String userName) {

		return userName.length() <= 30 && userName != null && userName.length() > 0;

	}

	public static boolean isValidEmailFormat(String email) {

		return email.contains("@") && (email.endsWith(".com") || email.endsWith(".in"));
	}

}
