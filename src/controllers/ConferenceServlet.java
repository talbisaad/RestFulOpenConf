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

/**
 * Servlet implementation class ConferenceServlet
 */
@WebServlet("/ConferenceServlet")
public class ConferenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConferenceService conferenceService;
	private ArrayList<Conference> conferenceList;
	private static final String CONFERENCELIST = "ConferenceList";
	private static final String DISPLAYCONFERENCE = "DisplayConference";
	private static final String MANAGECONFERENCE = "ManageConference";
	private static final String CREATECONFERENCE="CreateConference";

	@Override
	public void init() {
		conferenceService = new ConferenceServiceImpl();
	}

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String page = request.getRequestURL().substring(31);
		conferenceList = new ArrayList<Conference>();
		

		// Affichage de la liste des conferences

		switch (page) {
		case CONFERENCELIST:
			conferenceList = conferenceService.DisplayConferenceList();
			request.setAttribute("conferencelist", conferenceList);
			request.setAttribute("lengh", conferenceList.size());
			this.getServletContext().getRequestDispatcher("/ConferenceList.jsp").forward(request, response);
			break;

		case DISPLAYCONFERENCE:
			this.getServletContext().getRequestDispatcher("/DisplayConference.jsp").forward(request, response);
			break;

		case MANAGECONFERENCE:

			this.getServletContext().getRequestDispatcher("/ManageConference.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch(action){
		
		case CREATECONFERENCE:
			
			conferenceService.createConference(request);
			this.getServletContext().getRequestDispatcher("/DisplayConference.jsp").forward(conferenceService.displayConference(request), response);
			
			break;
		
		}
  
	}

}
