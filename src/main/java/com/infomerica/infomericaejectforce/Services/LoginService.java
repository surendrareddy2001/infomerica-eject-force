package com.infomerica.infomericaejectforce.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infomerica.infomericaejectforce.Constants.Contsants;
import com.infomerica.infomericaejectforce.DAO.User;
import com.infomerica.infomericaejectforce.DTO.Response;
import com.infomerica.infomericaejectforce.Repository.UserRepository;

/**
 * LoginService
 */
@Service
public class LoginService {

	private static Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * @param user
	 * @return isValidPassword
	 */
	public Response saveUserDetails(User user) {

		String userName = user.getUsername();
		String password = user.getPassword();
		String fullName = user.getFullname();
		long phoneNumber = user.getPhonenumber();
		String email = user.getEmail();
		logger.info("Email used for registration: {}", email);
		String errormessage = "null";
		int status = 0;
		boolean flag = true;
		logger.info("Entered into saveUserDetails : {} ", LocalDateTime.now());
		if (!isValidUserName(userName)) {
			errormessage =Contsants.USERNAME_VALIDATION;
			flag = false;
		}

		if (!isValidPassword(password)) {
			errormessage =Contsants.PASSWORD_VALIDATION;
			flag = false;
		}

		if (!isValidPhoneNumber(phoneNumber)) {
			errormessage = Contsants.PHONE_NUMBER_VALIDATION;
			flag = false;
		}

		if (!isValidEmailFormat(email)) {
			errormessage =Contsants.EMAIL_VALIDATION;
			flag = false;
		}

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encryptedPassword = passwordEncoder.encode(password);

		if (flag)
			status = userRepository.insertUserDetails(userName, encryptedPassword, fullName, phoneNumber, email);

		Response registrationResponse = new Response();

		if (status == 1) {
			logger.info("User is created by :{}",userName);
			registrationResponse.setStatus(HttpStatus.CREATED);
			registrationResponse.setMessage(Contsants.REGISTRATION_SUCESSE);
			registrationResponse.setErrorcode(errormessage);
			return registrationResponse;
		}

		else {
			logger.info("User creation failed due to :{}",errormessage);
			registrationResponse.setStatus(HttpStatus.BAD_REQUEST);
			registrationResponse.setMessage(Contsants.REGISTRATION_FAILURE);
			registrationResponse.setErrorcode(errormessage);
			return registrationResponse;
		}

	}

	/**
	 * @param password
	 * @return isValidPassword
	 */
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
		return digitCount >= 1 && specialCharCount >= 1;
	}

	/**
	 * @param phoneNumber
	 * @return isValidPhoneNumber
	 */
	public static boolean isValidPhoneNumber(long phoneNumber) {

		return Pattern.matches("[0-9]{10}", String.valueOf(phoneNumber));
	}

	/**
	 * @param userName 
	 * @return  isValidUserName
	 */
	public static boolean isValidUserName(String userName) {

		return userName.length() <= 30 && userName != null && userName.length() > 0;

	}

	/**
	 * @param email
	 * @return isValidEmailFormat
	 */
	public static boolean isValidEmailFormat(String email) {

		return email.contains("@") && (email.endsWith(".com") || email.endsWith(".in"));
	}

	/**
	 * @param email
	 * @param password
	 * @return validatePassword
	 */
	public boolean validatePassword(String email, String password) {
		List<com.infomerica.infomericaejectforce.DAO.User> users = userRepository.findAll();
		logger.info("data fetched from database at :{}",LocalDateTime.now());
		return users.stream().anyMatch(user -> passwordEncoder.matches(password, user.getPassword()));
	}
}
