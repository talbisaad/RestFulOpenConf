package services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import beans.Submission;
import ws.ConnectRest;
import ws.UtileSubmission;

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
		
		submission.setIdSubmission( responseAddSubmission.getString("id"));
			
	
	}

	
	public HttpServletRequest displaySubmission(HttpServletRequest request) {
		
		request.setAttribute("submission", this.submission);
		request.setAttribute("creation", FALSE );
		request.setAttribute("affichage", TRUE);
		
		return request;
	}
	
	@Override
	public HttpServletRequest displaysubmissionFromList(HttpServletRequest request) {
		
		JSONObject connexion = ConnectRest.connect();
		Submission responseAddSubmission = UtileSubmission.getsubmissionToReview(request.getParameter("idSubmission"), connexion);

		request.setAttribute("submission",responseAddSubmission);
		request.setAttribute("creation", FALSE );
		request.setAttribute("affichage", TRUE);
			
		
		return request;
	}
	//List of Modify
	@Override
	public Submission getSubmissionByIdForList(HttpServletRequest request) {
		
		;
		
		
		Submission sub = new Submission();
		sub.setIdSubmission("AAAA");
		sub.getConference().setConferanceName("Ingenering conference");
		sub.getUser().setMail("Saad@hotmail.fr");
		sub.setSubmissionTitle("Titre de submission");
		sub.setSubmissionTheme("le theme de la sub");
		
		request.setAttribute("submission", sub);
		
		return sub;
	} 

 
	
@Override
public ArrayList<Submission> getSubmissionListByConferenceSubject(HttpServletRequest request) {
		
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
		System.out.println("getSubmissionById " );

		//Faut chercher la submission par l'id 
			String idSubmission = request.getParameter("idSubmission");
			JSONObject connexion = ConnectRest.connect();
			Submission responseAddSubmission = UtileSubmission.getsubmissionToReview(idSubmission, connexion);

			request.setAttribute("submission", responseAddSubmission);
		return request;
	}

	@Override
	public void saveReviewSubmission(HttpServletRequest request) {
		
		//il me faut l'id de la submission en question.
		
 
		Submission s= new Submission();
		s.setIdSubmission(request.getParameter("submissionId"));
		s.setStatus(request.getParameter("droit"));
		s.setGrad(request.getParameter("Grad"));
		s.setReviewComments(request.getParameter("Comments"));
				
		
		JSONObject connexion = ConnectRest.connect();
		JSONObject responseAddSubmission = UtileSubmission.updateSubmissionByReviewer(s, connexion);

			
		
	}

	@Override
	public HttpServletRequest getSubmissionListById(HttpServletRequest request) {

	//	chercher avec : request.getParameter("mail");
		String email = request.getParameter("mail");
		JSONObject connexion = ConnectRest.connect();
		ArrayList<Submission>  responseAddSubmission = UtileSubmission.getsubmissionByEmail(email, connexion);
		
		request.setAttribute("lengh", responseAddSubmission.size());
		request.setAttribute("submissionList", responseAddSubmission);
		
		return request;
	}
	

	@Override
	public Submission getSubmission() {
		// TODO Auto-generated method stub
		return submission;
	}

	@Override
	public void setSubmission(Submission submission) {
		this.submission=submission;
		
	}

	@Override
	public HttpServletRequest updateSubmission(HttpServletRequest request) {


		//submission.setIdSubmission(request.getParameter("idSubmission"));
		submission.setSubmissionTitle(request.getParameter("submissionTitle"));			
		submission.setSubmissionTheme(request.getParameter("submissionTheme"));
		submission.setKeywords(request.getParameter("keywords"));
		submission.setSubmissionAbstract(request.getParameter("submissionAbstract"));
		JSONObject connexion = ConnectRest.connect();
		UtileSubmission.updateSubmission(submission, connexion);
		return displaySubmission(request);
		
	}

	@Override
	public HttpServletRequest deleteSubmission(HttpServletRequest request) {
		
		
		String idToDelete = submission.getIdSubmission();
		JSONObject connexion = ConnectRest.connect();
		UtileSubmission.deleteSubmission(idToDelete, connexion);
		
		return null;
	}

	 

	

	
	

		 


	 

	 
 

}
