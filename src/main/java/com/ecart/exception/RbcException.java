package com.ecart.exception;

public class RbcException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3722172893229695846L;

	RbcException() {
		super();
	}

	private String exceptionType;

	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public RbcException(String exceptionType, Throwable e) {
		super(e);
		this.exceptionType = exceptionType;
	}

}
