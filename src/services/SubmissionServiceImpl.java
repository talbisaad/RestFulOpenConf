package services;

import javax.servlet.http.HttpServletRequest;

import beans.Submission;

public class SubmissionServiceImpl implements SubmissionService{
	
	private Submission submission;
	
	 public SubmissionServiceImpl() {
		 submission= new Submission();
	 }

	public void createSubmission(HttpServletRequest request) {
		
		submission.getConference().setConferenceSubject(request.getParameter("conferenceSubject"));
		submission.setSubmissionTitle(request.getParameter("submissionTitle"));
		submission.getUser().setMail(request.getParameter("mail"));
		submission.setSubmissionTheme(request.getParameter("submissionTheme"));
		submission.setKeywords(request.getParameter("keywords"));
		submission.setSubmissionAbstract(request.getParameter("submissionAbstract"));		
		System.out.println(submission.toString());
		
	
		
	}

}
