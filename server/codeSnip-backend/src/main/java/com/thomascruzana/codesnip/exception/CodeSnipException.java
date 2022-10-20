package com.thomascruzana.codesnip.exception;

// custom exception class for codeSnip
public class CodeSnipException extends Exception {

	private static final long serialVersionUID = -3706841221652299526L;
	private static final String SIGNATURE = "codeSnip.ERROR: ";

	public CodeSnipException(String message) {
		super(SIGNATURE + message);
	}

}
