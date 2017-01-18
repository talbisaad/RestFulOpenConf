package services;

import java.util.ArrayList;

import beans.Conference;

public class ConferenceServiceImpl implements ConferenceService {
	
	ArrayList<Conference> conferenceList;
	
	public ConferenceServiceImpl() {
		conferenceList= new ArrayList<Conference>();
	}

	
	//affichage de la liste des conf�rence 
	public ArrayList<Conference> DisplayConferenceList() {

		Conference c1 = new Conference(0, "Name1", "Sub1", "20h30", 3, 0);
		Conference c2 = new Conference(0, "Name2", "Sub2", "20h30", 3, 0);
		Conference c3 = new Conference(0, "Name3", "Sub3", "20h30", 3, 0);
		Conference c4 = new Conference(0, "Name4", "Sub4", "20h30", 3, 0);
		
		conferenceList.add(c1);
		conferenceList.add(c2);
		conferenceList.add(c3);
		conferenceList.add(c4);
		return conferenceList;
	}

}
