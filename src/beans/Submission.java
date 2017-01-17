package beans;

public class Submission {
	
private int idSubmission;
private String submissionTitle;
private String submissionTheme;
private String keywords;
private String submissionAbstract;
private String status;

private User user;

private Conference conference;



public Submission(int idSubmission, String submissionTitle, String submissionTheme, String keywords,
		String submissionAbstract, String status) {
	super();
	this.idSubmission = idSubmission;
	this.submissionTitle = submissionTitle;
	this.submissionTheme = submissionTheme;
	this.keywords = keywords;
	this.submissionAbstract = submissionAbstract;
	this.status=status;
}


public Submission() {
	super();
	this.user=new User();
	this.conference= new Conference();
	// TODO Auto-generated constructor stub
}


public int getIdSubmission() {
	return idSubmission;
}
public void setIdSubmission(int idSubmission) {
	this.idSubmission = idSubmission;
}
public String getSubmissionTitle() {
	return submissionTitle;
}
public void setSubmissionTitle(String submissionTitle) {
	this.submissionTitle = submissionTitle;
}
public String getSubmissionTheme() {
	return submissionTheme;
}
public void setSubmissionTheme(String submissionTheme) {
	this.submissionTheme = submissionTheme;
}
public String getKeywords() {
	return keywords;
}
public void setKeywords(String keywords) {
	this.keywords = keywords;
}
public String getSubmissionAbstract() {
	return submissionAbstract;
}
public void setSubmissionAbstract(String submissionAbstract) {
	this.submissionAbstract = submissionAbstract;
}

public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}



public User getUser() {
	return this.user;
}



public Conference getConference() {
	return conference;
}


public void setConference(Conference conference) {
	this.conference = conference;
}



public void setUser(User user) {
	this.user = user;
}

@Override
public String toString() {
	return "Submission [submissionTitle=" + submissionTitle + ", submissionTheme=" + submissionTheme + ", keywords="
			+ keywords + ", submissionAbstract=" + submissionAbstract + "]";
}

 



}
