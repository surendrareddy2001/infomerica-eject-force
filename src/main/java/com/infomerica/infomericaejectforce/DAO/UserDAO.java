package com.infomerica.infomericaejectforce.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_INFO")
public class UserDAO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;
	@Column(name = "USERNAME")
	private String userName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "FULLNAME")
    private String fullName;
	@Column(name = "PHONENUMBER")
	private long phonenumber;
	@Column(name = "EMAIL")
	private String email;
	
	public UserDAO() {
		super();
	}
	public UserDAO( String username,String password, String fullName, long phonenumber, String email) {
		super();
		this.userName = username;
		this.password = password;
		this.fullName = fullName;
		this.phonenumber = phonenumber;
		this.email = email;
	}
	public String getUsername() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getFullname() {
		return fullName;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFullname(String fullname) {
		this.fullName = fullname;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserDAO [username=" + userName + ", password=" + password + ", fullname=" + fullName
				+ ", phonenumber=" + phonenumber + ", email=" + email + "]";
	}

}
