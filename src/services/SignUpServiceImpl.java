package services;


import javax.servlet.http.HttpServletRequest;

import beans.User;

public class SignUpServiceImpl implements SignUpService{

	private User user;
	
	public SignUpServiceImpl() {
	this.user= new User();
		
	}


	@Override
	public User SaveUser(HttpServletRequest request) {

		user.setUserName(request.getParameter("nom").toString());
		user.setUserLastName(request.getParameter("prenom").toString());
		
		System.out.println(user.toString());
		
		return null;
	}

}
