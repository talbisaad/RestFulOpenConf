package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Conference;
import services.ConferenceService;
import services.ConferenceServiceImpl;
import services.SubmissionService;
import services.SubmissionServiceImpl;

/**
 * Servlet implementation class SubmissionServlet
 */
@WebServlet("/SubmissionServlet")
public class SubmissionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 private ConferenceService conferenceService;
     private ArrayList<Conference> conferenceList;
     private SubmissionService submissionService;
     private static final String DISPLAYSUBMISSION ="DisplaySubmission";
     private static final String CREATESUBMISSION ="createSubmission";
	
     @Override
	public void init()  {
	submissionService= new SubmissionServiceImpl();	
		
	}
    public SubmissionServlet() {
       
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getRequestURL().substring(31);
		
		if(page.equals(DISPLAYSUBMISSION)){
			
			conferenceList= new ArrayList<Conference>();
			conferenceService= new ConferenceServiceImpl();
			conferenceList=conferenceService.DisplayConferenceList();
			request.setAttribute("conferencelist", conferenceList);
			request.setAttribute("lengh",conferenceList.size());	
			this.getServletContext().getRequestDispatcher("/DisplaySubmission.jsp").forward(request, response);
		}
		
		else{
			
			this.getServletContext().getRequestDispatcher("/ManageSubmission.jsp").forward(request, response);
		}
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		//Création d'une submission
		if(action.equals(CREATESUBMISSION)){
			submissionService.createSubmission(request);
			HttpServletRequest requestForDisplay=	submissionService.displaySubmission(request);			
			this.getServletContext().getRequestDispatcher("/DisplaySubmission.jsp").forward(requestForDisplay, response);
		}
		
		
	 
	}

}
