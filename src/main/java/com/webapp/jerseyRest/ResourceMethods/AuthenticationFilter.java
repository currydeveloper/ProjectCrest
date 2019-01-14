package com.webapp.jerseyRest.ResourceMethods;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements javax.servlet.Filter {
	public static final String AuthHeader = "Authorization";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpServRequest = (HttpServletRequest) request;
			String authCred = httpServRequest.getHeader(AuthHeader);
			AuthenticationService authServ = new AuthenticationService();
			boolean authStat = authServ.authenticate(authCred);
			if (authStat) {
				filter.doFilter(request, response);
			} else {
				if (response instanceof HttpServletResponse) {
					HttpServletResponse httpServResponse = (HttpServletResponse) response;
					httpServResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("this is  a servlet exception here");

	}

	@Override
	public void destroy() {
		System.out.println("this is  a destroy mode");

	}
}
