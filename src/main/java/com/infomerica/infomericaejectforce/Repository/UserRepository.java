package com.infomerica.infomericaejectforce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infomerica.infomericaejectforce.DAO.UserDAO;
@Repository
public interface UserRepository extends JpaRepository<UserDAO, Integer>{
	


}
