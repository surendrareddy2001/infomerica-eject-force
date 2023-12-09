package com.infomerica.infomericaejectforce.DTO;

import org.springframework.http.HttpStatus;

/**
 * Response Object
 */
public class Response {
	
	private HttpStatus status;
	private String message;
	private String errorcode;

	public String getMessage() {
		return message;
	}

	public String getErrorcode() {
		return errorcode;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
}
