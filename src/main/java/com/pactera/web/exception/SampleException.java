package com.pactera.web.exception;

public class SampleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2223477030370728998L;

	public SampleException() {

	}

	public SampleException(String msg) {
		super(msg);
	}

	public SampleException(Throwable e) {
		super(e.getMessage());
	}

}
