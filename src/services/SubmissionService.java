package services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.Submission;


public interface SubmissionService {

	void createSubmission(HttpServletRequest request);
	HttpServletRequest  displaySubmission(HttpServletRequest request);
	ArrayList<Submission> getSubmissionList(HttpServletRequest request);
	
}
