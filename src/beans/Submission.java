package beans;

public class Submission {
	
private int idSubmission;
private String submissionTitle;
private String submissionTheme;
private String keywords;
private String submissionAbstract;
private String status;



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





}
