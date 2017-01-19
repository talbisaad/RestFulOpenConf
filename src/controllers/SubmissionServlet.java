package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Conference;
import beans.Submission;
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
     private static final String  GETSUBMISSIONS="GetSubmissions";
     private static final String REVIEWSUBMISSION=	"ReviewSubmission";
	
     @Override
	public void init()  {
	submissionService= new SubmissionServiceImpl();	
		
	}
    public SubmissionServlet() {
       
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getRequestURL().substring(31);
		conferenceList= new ArrayList<Conference>();
		conferenceService= new ConferenceServiceImpl();
		conferenceList=conferenceService.DisplayConferenceList();
		request.setAttribute("conferencelist", conferenceList);
		request.setAttribute("lengh",conferenceList.size());	
		
		switch(page){
		
		case  DISPLAYSUBMISSION :
			
			
			this.getServletContext().getRequestDispatcher("/DisplaySubmission.jsp").forward(request, response);			
			break;
			
		  case REVIEWSUBMISSION:
			this.getServletContext().getRequestDispatcher("/ReviewSubmission.jsp").forward(request, response);
			break;
			
		}
		
		 
			
		 
		}
		
		 
		
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		//Création d'une submission
		
		switch(action){
		case CREATESUBMISSION :
			submissionService.createSubmission(request);
			HttpServletRequest requestForDisplay=	submissionService.displaySubmission(request);			
			this.getServletContext().getRequestDispatcher("/DisplaySubmission.jsp").forward(requestForDisplay, response);
			break;
		case GETSUBMISSIONS : 
			
			//affichage de la liste des submissions
			ArrayList<Submission> SubmissionList= new ArrayList<Submission>();
			SubmissionList=submissionService.getSubmissionList(request);
			request.setAttribute("SubmissionList",SubmissionList );
			request.setAttribute("lengh", SubmissionList.size());
			
			this.getServletContext().getRequestDispatcher("/ReviewSubmission.jsp").forward(request, response);
			break;
		}
		
		
		}
	}


