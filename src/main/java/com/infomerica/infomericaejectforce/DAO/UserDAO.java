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
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "FULLNAME")
    private String fullname;
	@Column(name = "PHONENUMBER")
	private long phonenumber;
	@Column(name = "EMAIL")
	private String email;
	
	public UserDAO() {
		super();
	}
	public UserDAO( String username,String password, String fullname, long phonenumber, String email) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.phonenumber = phonenumber;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFullname() {
		return fullname;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserDAO [username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", phonenumber=" + phonenumber + ", email=" + email + "]";
	}

}
