package org.apiviewer.commons.exception;

public class Error400 extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public Error400(Throwable cause) {
		super(cause);
	}

	public Error400(String message, Throwable cause) {
		super(message, cause);
	}

	public Error400(String message) {
		super(message);
	}

}
