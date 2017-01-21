package services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import beans.Conference;
import utility.ConnectRest;
import utility.UtileConference;

public class ConferenceServiceImpl implements ConferenceService {
	
	private ArrayList<Conference> responseGetConferenceList;
	private Conference conference;
	private static final String TRUE="true";
	private static final String FALSE="false";
	


	public ConferenceServiceImpl() {
		responseGetConferenceList= new ArrayList<Conference>();
		conference = new Conference();
	}

	
	//affichage de la liste des conférence 
	public ArrayList<Conference> DisplayConferenceList() {
		
		JSONObject connexion = ConnectRest.connect();
		System.out.println("connexion +++ --->" +connexion);
		responseGetConferenceList = UtileConference.getConferences(connexion);
		
		System.out.println("after response " +responseGetConferenceList);


		return responseGetConferenceList;
	}


	@Override
	public void createConference(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		
		//conference.setIdConference("tmp");
		conference.setConferanceName(request.getParameter("conferanceName"));
		conference.setConferenceSubject(request.getParameter("conferenceSubject"));
		//conference.setTime(request.getParameter("time"));
		conference.setParticipantNumber(Integer.parseInt(request.getParameter("participantNumber")));
		
		JSONObject connexion = ConnectRest.connect();
		System.out.println("connexion +++ --->" +connexion);
		UtileConference.addConference(conference, connexion);
		
		
		
			
	}
	
@Override
	public HttpServletRequest displayConference(HttpServletRequest request) {
		
		request.setAttribute("conference", getConference());
		request.setAttribute("creation", FALSE );
		request.setAttribute("affichage", TRUE);
		
		return request;
	}


	public ArrayList<Conference> getResponseGetConferenceList() {
		return responseGetConferenceList;
	}


	public void setResponseGetConferenceList(ArrayList<Conference> responseGetConferenceList) {
		this.responseGetConferenceList = responseGetConferenceList;
	}


	public Conference getConference() {
		return conference;
	}


	public void setConference(Conference conference) {
		this.conference = conference;
	}
	
}
