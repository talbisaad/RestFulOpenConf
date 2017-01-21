package services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.Submission;

public interface SubmissionService {
	void createSubmission(HttpServletRequest request);

	HttpServletRequest displaySubmission(HttpServletRequest request);

	ArrayList<Submission> getSubmissionListByConferenceSubject(HttpServletRequest request);
<<<<<<< HEAD

	HttpServletRequest getSubmissionListById(HttpServletRequest request);

=======
	
>>>>>>> e7d5ea9308fcd589dbba789d5320f70ea3439c7f
	HttpServletRequest getSubmissionById(HttpServletRequest request);
	//ma nouvelle methode
	Submission getSubmissionByIdForList(HttpServletRequest request);

	HttpServletRequest displaysubmissionFromList(HttpServletRequest request);

	void saveReviewSubmission(HttpServletRequest request);

	Submission getSubmission();

	void setSubmission(Submission submission);

	HttpServletRequest updateSubmission(HttpServletRequest request);
<<<<<<< HEAD

	HttpServletRequest deleteSubmission(HttpServletRequest request);
=======
	
	HttpServletRequest deleteSublission(HttpServletRequest request);
	
	
>>>>>>> e7d5ea9308fcd589dbba789d5320f70ea3439c7f

}
