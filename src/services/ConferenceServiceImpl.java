package services;

import java.util.ArrayList;

import org.json.JSONObject;

import beans.Conference;
import utility.ConnectRest;
import utility.UtileConference;

public class ConferenceServiceImpl implements ConferenceService {
	
	ArrayList<Conference> responseGetConferenceList;
	
	public ConferenceServiceImpl() {
		responseGetConferenceList= new ArrayList<Conference>();
	}

	
	//affichage de la liste des conférence 
	public ArrayList<Conference> DisplayConferenceList() {
		
		JSONObject connexion = ConnectRest.connect();
		System.out.println("connexion +++ --->" +connexion);
		responseGetConferenceList = UtileConference.getConference(connexion);
		
		System.out.println("after response " +responseGetConferenceList);


		return responseGetConferenceList;
	}

}
