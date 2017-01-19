package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Conference;
import services.ConferenceService;
import services.ConferenceServiceImpl;

/**
 * Servlet implementation class ConferenceServlet
 */
public class ConferenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ConferenceService conferenceService;
       private ArrayList<Conference> conferenceList;

   @Override
public void init() {


}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String page = request.getRequestURL().substring(31);
		conferenceList= new ArrayList<Conference>();
		conferenceService= new ConferenceServiceImpl();
		
		//Affichage de la liste des conf�rences 
		if(page.equals("ConferenceList")){
			conferenceList=conferenceService.DisplayConferenceList();
		request.setAttribute("conferencelist", conferenceList);
		request.setAttribute("lengh",conferenceList.size());
		this.getServletContext().getRequestDispatcher("/ConferenceList.jsp").forward(request, response);

		}
		if(page.equals("DisplayConference")){
		this.getServletContext().getRequestDispatcher("/DisplayConference.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 
	}

}
