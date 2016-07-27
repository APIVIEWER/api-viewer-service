package org.apiviewer.commons.filter;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/errorrequestlogging.properties")
@Configuration
public class ErrorLoggingFilterUtility {

	@Value("${httpstatuscode.request.error.logging}")
	private String delimitedErrorsForLogging;

	private static List<String> httpStatusCodes;

	@PostConstruct
	private void constructErrorsForLogging() {

		if (null == httpStatusCodes || httpStatusCodes.isEmpty()) {
			String httpStatuses[] = delimitedErrorsForLogging.split(",");
			httpStatusCodes = Arrays.asList(httpStatuses);
			;
		}

	}

	public static boolean isErrorHttpStatusCode(int responseStatusCode) {

		return httpStatusCodes.contains(String.valueOf(responseStatusCode));
	}
}
