package com.site.joblisting.exceptions;

public class JobNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	final String message;

	public  JobNotFoundException(String message) {
		super(message);
		this.message = message;
	} 

}
