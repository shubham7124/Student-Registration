package com.registration.student.controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseNotFound {

	private String message;
	private Boolean status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public ResponseNotFound(String message, Boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	@Override
	public String toString() {
		return "DeleteResponse [message=" + message + ", status=" + status + "]";
	}
	
	
	
}
