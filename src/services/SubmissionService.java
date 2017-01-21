package services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.Submission;

public interface SubmissionService {
	void createSubmission(HttpServletRequest request);

	HttpServletRequest displaySubmission(HttpServletRequest request);

	ArrayList<Submission> getSubmissionListByConferenceSubject(HttpServletRequest request);

	HttpServletRequest getSubmissionListById(HttpServletRequest request);

	
	HttpServletRequest getSubmissionById(HttpServletRequest request);
	//ma nouvelle methode
	Submission getSubmissionByIdForList(HttpServletRequest request);

	HttpServletRequest displaysubmissionFromList(HttpServletRequest request);

	void saveReviewSubmission(HttpServletRequest request);

	Submission getSubmission();

	void setSubmission(Submission submission);

	HttpServletRequest updateSubmission(HttpServletRequest request);

	HttpServletRequest deleteSubmission(HttpServletRequest request);
	
	
	

}
