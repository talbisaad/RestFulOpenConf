package beans;

import java.sql.Date;
import java.util.ArrayList;

public class Conference {
	
	private int idConference;
	private String conferanceName;
	private String conferenceSubject;
	private Date  time;
	private int participantNumber;
	private int actualparticipantNumber;
	private ArrayList<Submission> submissionList;
	
	


	public Conference(int idConference, String conferanceName, String conferenceSubject, Date time,
			int participantNumber, int actualparticipantNumber) {
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


	public int getIdConference() {
		return idConference;
	}
	public void setIdConference(int idConference) {
		this.idConference = idConference;
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getParticipantNumber() {
		return participantNumber;
	}
	public void setParticipantNumber(int participantNumber) {
		this.participantNumber = participantNumber;
	}
	public int getActualparticipantNumber() {
		return actualparticipantNumber;
	}
	public void setActualparticipantNumber(int actualparticipantNumber) {
		this.actualparticipantNumber = actualparticipantNumber;
	}
	
	public ArrayList<Submission> getSubmissionList() {
		return submissionList;
	}


	public void setSubmissionList(ArrayList<Submission> submissionList) {
		this.submissionList = submissionList;
	}
	
	
	

}
