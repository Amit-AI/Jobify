package com.site.joblisting.exceptions;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	final String message;

	public NotFoundException(String message) {
		super(message);
		this.message = message;
	}
    
}
