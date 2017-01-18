package services;


import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import beans.User;
import utility.ConnectRest;
import utility.Utile;

public class SignUpServiceImpl implements SignUpService{

	private User user;
	
	public SignUpServiceImpl() {
	this.user= new User();
		
	}


	public User SaveUser(HttpServletRequest request) {

		user.setUserName(request.getParameter("nom").toString());
		user.setUserLastName(request.getParameter("prenom").toString());
		
		//System.out.println("ConnectRest.connect() --->" +ConnectRest.connect());

		JSONObject connexion = ConnectRest.connect();
		System.out.println("connexion +++ --->" +connexion);
		JSONObject responseAddUser = Utile.addUser(user, connexion);
		
	
		System.out.println(user.toString());
		System.out.println("****"+ responseAddUser);
		

		return null;
	}
	
	 

}
