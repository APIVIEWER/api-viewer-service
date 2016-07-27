package org.apiviewer.commons.exception;

public class Error404 extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public Error404(Throwable cause) {
		super(cause);
	}

	public Error404(String message, Throwable cause) {
		super(message, cause);
	}

	public Error404(String message) {
		super(message);
	}

}
