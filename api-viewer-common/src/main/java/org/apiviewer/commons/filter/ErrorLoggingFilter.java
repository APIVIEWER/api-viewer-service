package org.apiviewer.commons.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;

/**
 * Based on configured HTTP Status Code, the filter enables to log Request
 * Object.
 * 
 * @author hitesh.bargujar
 *
 */
@Component
public class ErrorLoggingFilter implements Filter {

	private final Logger log = LoggerFactory.getLogger(ErrorLoggingFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpServletRequest requestToUse = new ContentCachingRequestWrapper(req);

		ContentCachingRequestWrapper requestWrapper = (ContentCachingRequestWrapper) requestToUse;

		// requestToUse in an object of ContentCachingRequestWrapper
		chain.doFilter(requestToUse, response);

		// Only Log the Request Object when an Error or Exception occurs
		if (ErrorLoggingFilterUtility.isErrorHttpStatusCode(res.getStatus())) {

			log.error("Failed Request ::: Status Code {} -- URI {} -- Parameters {} -- Body{}", res.getStatus(),
					requestWrapper.getRequestURI().toString(), "", new String(requestWrapper.getContentAsByteArray(), 0,
							requestWrapper.getContentAsByteArray().length, requestWrapper.getCharacterEncoding()));
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
