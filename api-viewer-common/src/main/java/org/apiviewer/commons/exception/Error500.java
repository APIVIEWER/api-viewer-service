package org.apiviewer.commons.exception;

public class Error500 extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public Error500(Throwable cause) {
		super(cause);
	}

	public Error500(String message, Throwable cause) {
		super(message, cause);
	}

	public Error500(String message) {
		super(message);
	}

}
