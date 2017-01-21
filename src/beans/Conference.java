package beans;

import java.util.ArrayList;

public class Conference {
	
	private String idConference;
	private String conferanceName;
	private String conferenceSubject;
	private String  time; // format date in database 2017-01-12
	private int participantNumber;
	private String actualparticipantNumber;
	private ArrayList<Submission> submissionList;
	
	

	public Conference(String idConference, String conferanceName, String conferenceSubject, String time,
			int participantNumber, String actualparticipantNumber) {
		super();
		this.idConference = idConference;
		this.conferanceName = conferanceName;
		this.conferenceSubject = conferenceSubject;
		this.time = time;
		this.participantNumber = participantNumber;
		this.actualparticipantNumber = actualparticipantNumber;
	}
	
	
	public Conference() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Conference(String idConference2, String conferanceName2, String conferenceSubject2, String time2,
			String string, String actualparticipantNumber2) {
		// TODO Auto-generated constructor stub
	}


	public String getIdConference() {
		return idConference;
	}
	public void setIdConference(String conferenceId) {
		this.idConference = conferenceId;
	}
	public String getConferanceName() {
		return conferanceName;
	}
	public void setConferanceName(String conferanceName) {
		this.conferanceName = conferanceName;
	}
	public String getConferenceSubject() {
		return conferenceSubject;
	}
	public void setConferenceSubject(String conferenceSubject) {
		this.conferenceSubject = conferenceSubject;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getParticipantNumber() {
		return participantNumber;
	}
	public void setParticipantNumber(int participantNumber) {
		this.participantNumber = participantNumber;
	}
	public String getActualparticipantNumber() {
		return actualparticipantNumber;
	}
	public void setActualparticipantNumber(String number_of_participants__c) {
		this.actualparticipantNumber = number_of_participants__c;
	}
	
	public ArrayList<Submission> getSubmissionList() {
		return submissionList;
	}


	public void setSubmissionList(ArrayList<Submission> submissionList) {
		this.submissionList = submissionList;
	}
	
	
	

}
