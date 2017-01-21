package services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import beans.Submission;
import utility.ConnectRest;
import utility.UtileSubmission;

public class SubmissionServiceImpl implements SubmissionService{
	
	private Submission submission;
	private static final String TRUE="true";
	private static final String FALSE="false";
	
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
		
		JSONObject connexion = ConnectRest.connect();
		System.out.println("connexion +++ --->" +connexion);
		JSONObject responseAddSubmission = UtileSubmission.addSubmission(submission, connexion);
		
		
		System.out.println("responseAddSubmission --> "+ responseAddSubmission);
		
	
	}

	
	public HttpServletRequest displaySubmission(HttpServletRequest request) {
		
		request.setAttribute("submission", this.submission);
		request.setAttribute("creation", FALSE );
		request.setAttribute("affichage", TRUE);
		
		return request;
	}

	public ArrayList<Submission> getSubmissionList(HttpServletRequest request) {
		
		String conferenceSubject = request.getParameter("conferenceSubject");
		
		JSONObject connexion = ConnectRest.connect();	
		System.out.println("get conferenceName ++++ "+ conferenceSubject );
		ArrayList<Submission> s = new  ArrayList<Submission>();
		s = UtileSubmission.getsubmissionList(conferenceSubject, connexion);
		System.out.println("object subminssin ---> "+ s );

		return s;
	}

	@Override
	public HttpServletRequest getSubmissionById(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		//Faut chercher la submission par l'id 
			Submission sub = new Submission();
			
			sub.getConference().setConferanceName("Ingenering conference");
			sub.getUser().setMail("Saad@hotmail.fr");
			sub.setSubmissionTitle("Titre de submission");
			sub.setSubmissionTheme("le theme de la sub");
			
			request.setAttribute("submission", sub);
		return request;
	}

	@Override
	public void saveReviewSubmission(HttpServletRequest request) {
		
		//il me faut l'id de la submission en question.
		String submissionId = "TYUPZJJZ";
		
		JSONObject connexion = ConnectRest.connect();
		JSONObject responseAddSubmission = UtileSubmission.updateSubmissionByReviewer(submissionId, connexion);

		

		
		Submission sub = new Submission();
		
		sub.setStatus(request.getParameter("droit"));
		sub.setReviewComments(request.getParameter("Comments"));
		sub.setGrad(request.getParameter("Grad"));
		
		
		
	}

	@Override
	public HttpServletRequest getSubmissionListById(HttpServletRequest request) {

		 
		
		//request.setAttribute("conferencelistbyId", conferencelistbyId);
		
		return request;
	}
 

}
