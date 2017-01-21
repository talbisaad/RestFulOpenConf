package services;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import beans.User;
import utility.ConnectRest;
import utility.UtileUser;

public class SignUpServiceImpl implements SignUpService {

	private User user;

	public SignUpServiceImpl() {
		this.user = new User();

	}

	public User SaveUser(HttpServletRequest request) {

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
	 

}
