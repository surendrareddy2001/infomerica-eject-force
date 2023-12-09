package com.infomerica.infomericaejectforce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infomerica.infomericaejectforce.DAO.User;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

	/**
	 * @return
	 */
	@Query("SELECT u FROM UserDAO u")
	List<User> findAllUsers();

	/**
	 * @param username
	 * @param password
	 * @param fullname
	 * @param phoneNumber
	 * @param email
	 * @return
	 */
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO USER_INFO (USERNAME, PASSWORD, FULLNAME, PHONENUMBER, EMAIL) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
	int insertUserDetails(String username, String password, String fullname, Long phoneNumber, String email);
}
