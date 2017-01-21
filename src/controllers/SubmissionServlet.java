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
import utility.UtileSubmission;

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
     private static final String MANAGESUBMISSION="ManageSubmission";
     private static final String  GETSUBMISSIONS="GetSubmissions";
     private static final String GETSUBLISTFORREVIEW=	"GetSubmissionListForReview";
     private static final String REVIEW="Review";
     private static final String SAVEREVIEW="SaveReview";
     private static final String UPDATESUBMISSION="UpdateSubmission";
     private static final String SAVEMANAGESUBMISSION="SaveManageSubmission";
     private static final String DELETESUBMISSION="DeleteSubmission";
     private static final String SEARCHSUBMISSION="SearchSubmission";
     private static final String SUBMISSIONLIST="SubmissionList";
     private static final String UPDATESUBFROMLIST="UpdateSubFromList";
     
     
	
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
			
		  case GETSUBLISTFORREVIEW:
			this.getServletContext().getRequestDispatcher("/GetSubmissionListForReview.jsp").forward(request, response);
			break;
		  case MANAGESUBMISSION:
			  this.getServletContext().getRequestDispatcher("/ManageSubmission.jsp").forward(request, response);
				break;		 
		  case SUBMISSIONLIST:
			  this.getServletContext().getRequestDispatcher("/SubmissionList.jsp").forward(request, response);
			  break;
		}				 					 
		}
		
		 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		
		switch(action){
		case CREATESUBMISSION :
			submissionService.createSubmission(request);
			HttpServletRequest requestForDisplay=	submissionService.displaySubmission(request);	
			this.getServletContext().getRequestDispatcher("/DisplaySubmission.jsp").forward(requestForDisplay, response);
			break;
		case GETSUBMISSIONS : 
			
			//affichage de la liste des submissions
			ArrayList<Submission> SubmissionList= new ArrayList<Submission>();
			SubmissionList=submissionService.getSubmissionListByConferenceSubject(request);
			request.setAttribute("SubmissionList",SubmissionList );
			request.setAttribute("lengh", SubmissionList.size());
			
			this.getServletContext().getRequestDispatcher("/GetSubmissionListForReview.jsp").forward(request, response);
			break;
			
		case REVIEW:
			//review submission
			this.getServletContext().getRequestDispatcher("/ReviewSubmission.jsp").forward(submissionService.getSubmissionById(request), response);			 
			break;
			
		case SAVEREVIEW:
			//save Review submission
			submissionService.saveReviewSubmission(request);
			this.getServletContext().getRequestDispatcher("/GetSubmissionListForReview.jsp").forward(request, response);
			break;
			
		case UPDATESUBMISSION:
			 		
			request.setAttribute("submissionThemes", UtileSubmission.getSubmissionsThemes());
			request.setAttribute("submission", submissionService.getSubmission());
			this.getServletContext().getRequestDispatcher("/ManageSubmission.jsp").forward(request, response);
			break;
			
		  case SAVEMANAGESUBMISSION:
			  
			  
			  this.getServletContext().getRequestDispatcher("/DisplaySubmission.jsp").forward(submissionService.updateSubmission(request), response);
			 break;
			 
		  case DELETESUBMISSION:
			 
				submissionService.deleteSubmission(request);
				this.getServletContext().getRequestDispatcher("/DisplaySubmission.jsp").forward(request, response);
			  break;
			  
		  case SEARCHSUBMISSION:
			  
			  
			  this.getServletContext().getRequestDispatcher("/SubmissionList.jsp").forward(submissionService.getSubmissionListById(request), response);

			  break;
			
			
		case UPDATESUBFROMLIST:
			
			 request.setAttribute("submissionThemes", UtileSubmission.getSubmissionsThemes());
			 this.getServletContext().getRequestDispatcher("/ManageSubmission.jsp").forward(submissionService.displaysubmissionFromList(request),response);	
			 break;
		
		}
		 	}
	}


