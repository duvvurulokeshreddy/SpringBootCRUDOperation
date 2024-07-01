package com.jsp.springboot.actor.exception;

public class ActorNotFoundByIdException extends RuntimeException{
	
	private String message;

	public ActorNotFoundByIdException(String message) {
		this.message = message;
	}
	
	

	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	@Override
	public String toString() {
		return "ActorNotFoundByIdException [message=" + message + "]";
	}

	
	
	

}
