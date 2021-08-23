package com.random.gen.exceptions;

public class OpererationUnSupportedException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8233186629891702913L;

	public OpererationUnSupportedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public OpererationUnSupportedException(String message) {
		super(message);
	}
}
