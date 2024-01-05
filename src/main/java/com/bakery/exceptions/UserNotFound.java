package com.bakery.exceptions;

public class UserNotFound extends RuntimeException{
	public UserNotFound(String exception) {
		super(exception);
	}
}
