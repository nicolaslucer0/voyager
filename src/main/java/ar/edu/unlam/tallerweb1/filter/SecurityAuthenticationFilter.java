package ar.edu.unlam.tallerweb1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityAuthenticationFilter implements Filter {

	public static final String LOGIN_URL = "/login";
	public static final String SIGNUP_URL = "/signup";

	@Override
	public void doFilter(ServletRequest request, 
               ServletResponse response, FilterChain chain)
		throws IOException, ServletException {

		if(isHttpRequest(request)) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			
			if(shouldValidate(httpRequest) && isNotAuthenticated(httpRequest)) {
				
				/* Unauthenticated request, send to login */
				((HttpServletResponse) response).sendRedirect(LOGIN_URL);
				return;
			}
		}
		
		/* Valid request, should proceed */
		chain.doFilter(request, response);		
	}

	private boolean isNotAuthenticated(HttpServletRequest httpRequest) {
		return UserSessionRetriever.getUserFromSession(httpRequest) == null;
	}

	private boolean shouldValidate(HttpServletRequest request) {
		return !request.getRequestURI().startsWith(LOGIN_URL)
				&& !request.getRequestURI().startsWith(SIGNUP_URL);
	}

	private boolean isHttpRequest(ServletRequest request) {
		return HttpServletRequest.class.isAssignableFrom(request.getClass());
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
