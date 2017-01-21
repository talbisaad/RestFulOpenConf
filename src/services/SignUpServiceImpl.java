package services;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import beans.User;
import ws.ConnectRest;
import ws.UtileUser;

public class SignUpServiceImpl implements SignUpService {

	private User userSignIn;

	public SignUpServiceImpl() {
		userSignIn= new User();
	}

	public User SaveUser(HttpServletRequest request) {
		  User user = new User();

		user.setUserName(request.getParameter("nom").toString());
		user.setUserLastName(request.getParameter("prenom").toString());
		user.setMail(request.getParameter("e-mail").toString());
		user.setPassword(request.getParameter("password"));

		String[] list = request.getParameterValues("droit");

		for (int i = 0; i < list.length; i++) {

			if (list[i].equals("chercheur"))
				user.setChercheur(true);

			if (list[i].equals("Reviewer"))
				user.setReviewer(true);
			;

			if (list[i].equals("Comite"))
				user.setComite(true);

		}
	

	// System.out.println("ConnectRest.connect() --->" +ConnectRest.connect());

	JSONObject connexion = ConnectRest.connect();
	
	System.out.println("connexion +++ --->"+connexion);
	JSONObject responseAddUser = UtileUser.addUser(user, connexion);

	System.out.println(user.toString());
	
	System.out.println("****"+responseAddUser);

	return null;
	
	}

	@Override
	public User signIn(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		
		userSignIn.setMail(request.getParameter("username"));
		userSignIn.setPassword(request.getParameter("password"));
		
		
		JSONObject connexion = ConnectRest.connect();
		UtileUser.sign(userSignIn.getMail(), userSignIn.getPassword(), connexion);
		
		
		//if(userResult!=null)
	//	return userSignIn;
		return null;
	}
	
	 

}
