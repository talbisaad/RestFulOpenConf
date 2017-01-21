package beans;

public class User {

	
	private String idUser;
	private String userName;
	private String userLastName;
	private String mail;
	private String password;
	private String profile;
	private boolean Chercheur;
	private boolean Comite;
	private boolean Reviewer;

	
		
	public boolean isChercheur() {
		return Chercheur;
	}

	public void setChercheur(boolean chercheur) {
		Chercheur = chercheur;
	}

	public boolean isComite() {
		return Comite;
	}

	public void setComite(boolean comite) {
		Comite = comite;
	}

	public boolean isReviewer() {
		return Reviewer;
	}

	public void setReviewer(boolean reviewer) {
		Reviewer = reviewer;
	}

	public User(String idUser, String userName, String userLastName, String mail, String password, String profile) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.userLastName = userLastName;
		this.mail = mail;
		this.password = password;
		this.profile = profile;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
		super();
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String userId) {
		this.idUser = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userLastName=" + userLastName + "]";
	}



	
	
}
