package services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.Submission;

public interface SubmissionService {
	void createSubmission(HttpServletRequest request);

	HttpServletRequest displaySubmission(HttpServletRequest request);

	ArrayList<Submission> getSubmissionList(HttpServletRequest request);
<<<<<<< HEAD
	HttpServletRequest 	getSubmissionById(HttpServletRequest request);
	void saveReviewSubmission(HttpServletRequest request);
	HttpServletRequest getSubmissionListById(HttpServletRequest request);
=======

	HttpServletRequest getSubmissionById(HttpServletRequest request);

	void saveReviewSubmission(HttpServletRequest request);

	Submission getSubmission();

	void setSubmission(Submission submission);
	
	HttpServletRequest updateSubmission(HttpServletRequest request);
>>>>>>> 3906eeff8c2f64b669724961c1c4a013b3c27921
	
	HttpServletRequest deleteSublission(HttpServletRequest request);
	

}
