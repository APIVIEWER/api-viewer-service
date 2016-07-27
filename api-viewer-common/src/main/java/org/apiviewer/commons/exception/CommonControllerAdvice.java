package org.apiviewer.commons.exception;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonControllerAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommonControllerAdvice.class);

	@ExceptionHandler(value = { Error500.class, RuntimeException.class })
	public ResponseEntity<CommonErrorConstruct> handleError500Exception(Exception e) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Exception Occured while processing the request {}", e.getMessage());
		}

		return new ResponseEntity<CommonErrorConstruct>(
				new CommonErrorConstruct("We are unable to process the request", e.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { Error400.class, MethodArgumentNotValidException.class })
	public ResponseEntity<CommonErrorConstruct> handleException(Exception e) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Request Validation Exception {}", e.getMessage());
		}

		return new ResponseEntity<CommonErrorConstruct>(
				new CommonErrorConstruct("Request Validation Exception", e.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { Error404.class })
	public ResponseEntity<CommonErrorConstruct> handleError404Exception(Exception e) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Resource not found {}", e.getMessage());
		}

		return new ResponseEntity<CommonErrorConstruct>(new CommonErrorConstruct("Resource not found", e.getMessage()),
				HttpStatus.NOT_FOUND);
	}

	public static class CommonErrorConstruct implements Serializable {

		private static final long serialVersionUID = 1868832609654873988L;

		private String errorDescription;
		private String exceptionCausedBy;

		public CommonErrorConstruct() {

		}

		public CommonErrorConstruct(String errorDescription, String exceptionCausedBy) {
			this.errorDescription = errorDescription;
			this.exceptionCausedBy = exceptionCausedBy;
		}

		public String getErrorDescription() {
			return errorDescription;
		}

		public void setErrorDescription(String errorDescription) {
			this.errorDescription = errorDescription;
		}

		public String getExceptionCausedBy() {
			return exceptionCausedBy;
		}

		public void setExceptionCausedBy(String exceptionCausedBy) {
			this.exceptionCausedBy = exceptionCausedBy;
		}

	}
}
