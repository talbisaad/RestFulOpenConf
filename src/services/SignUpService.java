package services;

import javax.servlet.http.HttpServletRequest;

import beans.User;

public interface SignUpService {
	
	User SaveUser(HttpServletRequest request);

}
