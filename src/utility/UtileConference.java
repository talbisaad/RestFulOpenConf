package utility;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beans.Conference;

public class UtileConference {
	
	//public static ArrayList<String> conference= new ArrayList<String>();
	public static ArrayList<Conference> conferenceList = new ArrayList<Conference>();
	public static Conference conference;

	public static String conferenceId;
	public static String Name;
	public static int Number_of_participants__c;
	public static String Subject__c;
	public static String baseUri;
	private static String loginAccessToken;
	private static Header oauthHeader;
	private static Header prettyPrintHeader = new BasicHeader("X-PrettyPrint", "1");
	
	public static ArrayList<Conference> getConference(JSONObject data) {
		
        
		try {
			baseUri = data.getString("baseUri");
			System.out.println("DATA --> " + baseUri);
			loginAccessToken = data.getString("loginAccessToken");
		} catch (JSONException jsonException) {
			jsonException.printStackTrace();
		}

		oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken);
		if(conferenceList!=null)
			conferenceList.clear();
		try{
        HttpClient httpClient = HttpClientBuilder.create().build();

		String uri = baseUri + "/query?q=Select+Id+,+Name+,+Number_of_participants__c+,+Subject__c+From+Manager_Conference__c";
        System.out.println("Query URL: " + uri);
        HttpGet httpGet = new HttpGet(uri);
        httpGet.addHeader(oauthHeader);
        httpGet.addHeader(prettyPrintHeader);

        // Make the request.
        HttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            String response_string = EntityUtils.toString(response.getEntity());
            try {
                JSONObject json = new JSONObject(response_string);
                System.out.println("JSON return of Query:\n" + json.toString(1));
                JSONArray j = json.getJSONArray("records");

                for (int i = 0; i < j.length(); i++){
                    conference= new Conference();

                	conferenceId = json.getJSONArray("records").getJSONObject(i).getString("Id");
                	conference.setIdConference(conferenceId);
                	
                	Name = json.getJSONArray("records").getJSONObject(i).getString("Name");
                	conference.setConferanceName(Name);

                	Number_of_participants__c = json.getJSONArray("records").getJSONObject(i).getInt("Number_of_participants__c");
                	conference.setParticipantNumber(Number_of_participants__c);
                	
                	Subject__c = json.getJSONArray("records").getJSONObject(i).getString("Subject__c");
                	conference.setConferenceSubject(Subject__c);


                    conferenceList.add(conference);
                   
                    
                    
                	
                    System.out.println("conference conference is: " + i + ". " + conferenceId + " " + Name + " " + Number_of_participants__c + "(" + Subject__c + ")");
                }
                
                System.out.println("list conf --> Utilconference "+conferenceList);

                return conferenceList;
            } catch (JSONException je) {
                je.printStackTrace();
            }
        } else {
            System.out.println("Hoops ça marche pas . Status erreur " + statusCode);
            System.out.println("ERROR NUMBER: " + response.getStatusLine().getStatusCode());
            //System.out.println(getBody(response.getEntity().getContent()));
            System.exit(-1);
        }
		
		
        
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        
        
        
		return null;
        
        

		
		
	}

	
	

}