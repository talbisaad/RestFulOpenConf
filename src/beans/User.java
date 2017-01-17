package beans;

public class User {

	
	private int idUser;
	private String userName;
	private String userLastName;
	private String mail;
	private String password;
	private String profile;
	
		
	public User(int idUser, String userName, String userLastName, String mail, String password, String profile) {
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
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
