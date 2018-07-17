package ar.edu.unlam.tallerweb1.filter;

import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.model.User;

public abstract class UserSessionRetriever {

	public static User getUserFromSession(HttpServletRequest request) {
		if (request.getSession().getAttribute("USER") != null)
			return (User) request.getSession().getAttribute("USER");
		else
			return null;
	}
}
