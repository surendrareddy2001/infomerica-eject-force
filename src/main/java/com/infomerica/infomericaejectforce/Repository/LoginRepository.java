package com.infomerica.infomericaejectforce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infomerica.infomericaejectforce.DAO.UserDAO;

@Repository
public interface LoginRepository extends JpaRepository<UserDAO, String> {

	

    @Query("SELECT u FROM UserDAO u")
    List<UserDAO> findAllUsers();
    
//	@Transactional
//	@Modifying
//    @Query(value="SELECT password FROM UserDAO  WHERE USERNAME = ?",nativeQuery= true)
//    int findByUsername(String userName);
    
//    @Query(value = "INSERT INTO USER_INFO (USERNAME, PASSWORD, FULLNAME, PHONENUMBER, EMAIL) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
//    int save(String username, String password, String fullname, Long phoneNumber, String email);

//    @Query("SELECT u FROM UserDAO u WHERE u.id = ?1")
//    UserDAO findUserById(String id);
}
