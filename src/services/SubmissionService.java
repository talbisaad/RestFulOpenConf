package services;

import javax.servlet.http.HttpServletRequest;


public interface SubmissionService {

	void createSubmission(HttpServletRequest request);
	HttpServletRequest  displaySubmission(HttpServletRequest request);
	
}
