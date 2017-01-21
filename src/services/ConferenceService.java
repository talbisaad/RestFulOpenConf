package services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.Conference;

public interface ConferenceService {
	
	  ArrayList<Conference> DisplayConferenceList();
	  void createConference(HttpServletRequest request);
	 HttpServletRequest displayConference(HttpServletRequest request);
}
