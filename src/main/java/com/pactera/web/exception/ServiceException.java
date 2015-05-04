package com.pactera.web.exception;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2223477030370728998L;

	public ServiceException() {

	}

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(Throwable e) {
		super(e.getMessage());
	}

}
