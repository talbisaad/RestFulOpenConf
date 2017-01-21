package ws;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.http.Header;

import beans.Submission;
import beans.User;

public class UtileUser {

	public static String userId;
	public static String profilId;
	public static String baseUri;
	private static String loginAccessToken;
	private static Header oauthHeader;
	private static Header prettyPrintHeader = new BasicHeader("X-PrettyPrint", "1");
	private static User user;
	private static String name;

	public static JSONObject addUser(User user, JSONObject data) {

		try {
			baseUri = data.getString("baseUri");
			System.out.println("DATA --> " + baseUri);
			loginAccessToken = data.getString("loginAccessToken");
		} catch (JSONException jsonException) {
			jsonException.printStackTrace();
		}

		oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken);
		String uri = baseUri + "/sobjects/User_App__c/";

		JSONObject u = new JSONObject();
		u.put("Name", user.getUserName());
		u.put("Last_name__c", user.getUserLastName());
		u.put("Password__c", "12390");
		u.put("Email__c", user.getMail());
		

		try {
			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpPost httpPost = new HttpPost(uri);
			httpPost.addHeader(oauthHeader);
			httpPost.addHeader(prettyPrintHeader);

			StringEntity body = new StringEntity(u.toString(1));
			body.setContentType("application/json");
			httpPost.setEntity(body);

			// Allons-y !
			HttpResponse response = httpClient.execute(httpPost);
			// Process the results
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 201) {
				String response_string = EntityUtils.toString(response.getEntity());
				JSONObject json = new JSONObject(response_string);
				// get ID of new record has been added 
				userId = json.getString("id");
				
				int statProfil = addprofil(userId, user.isChercheur(), user.isComite(), user.isReviewer(), data);
				System.out.println("ID  de new USER: " + userId + "");

				System.out.println("CODE PROFILE: " + statProfil + "");
			} else {
				System.out.println("Insertion unsuccessful. Status code returned is " + statusCode);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}

		return null;

	}
	
	public static  int addprofil(String userId, boolean chercheur, boolean comite, boolean reviewer,JSONObject data  ){
		int statusCode = 0;
		
		try {
			baseUri = data.getString("baseUri");
			System.out.println("DATA --> " + baseUri);
			loginAccessToken = data.getString("loginAccessToken");
		} catch (JSONException jsonException) {
			jsonException.printStackTrace();
		}

		oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken);
		String uri = baseUri + "/sobjects/Profil__c/";

		JSONObject p = new JSONObject();
		p.put("User__c", userId);
		p.put("Chercheur__c", chercheur);
		p.put("Comite__c", comite);
		p.put("Reviewer__c", reviewer);

		try {
			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpPost httpPost = new HttpPost(uri);
			httpPost.addHeader(oauthHeader);
			httpPost.addHeader(prettyPrintHeader);

			StringEntity body = new StringEntity(p.toString(1));
			body.setContentType("application/json");
			httpPost.setEntity(body);

			// Allons-y !
			HttpResponse response = httpClient.execute(httpPost);
			// Process the results
			statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 201) {
				String response_string = EntityUtils.toString(response.getEntity());
				JSONObject json = new JSONObject(response_string);
				// get ID of new record has been added 
				profilId = json.getString("id");
				System.out.println("ID  de new profil: " + profilId + "");
			} else {
				System.out.println("OPPS marche pas " + statusCode);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}

		//return null;
		
		
		
		return statusCode;
		
	}

	
	public static User sign(String email ,  String password , JSONObject data ){
		
				try {
					baseUri = data.getString("baseUri");
					System.out.println("DATA --> " + baseUri);
					loginAccessToken = data.getString("loginAccessToken");
				} catch (JSONException jsonException) {
					jsonException.printStackTrace();
				}

				oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken);
				//if(submissionList!=null)
				//	submissionList.clear();
				try{
		        HttpClient httpClient = HttpClientBuilder.create().build();
				String uri = baseUri + "/query?q=Select+Id+,+Name+,+Password__c+,+Email__c+From+User_App__c+where+Email__c='"+email+"'+AND+Password__c='"+password+"'";         
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
		                
		                	user= new User();
		                		
		                	userId = json.getJSONArray("records").getJSONObject(0).getString("Id");
		                	user.setIdUser(userId);
		                	
		                	password = json.getJSONArray("records").getJSONObject(0).getString("Password__c");
		                	user.setPassword(password);
		                	
		                	email = json.getJSONArray("records").getJSONObject(0).getString("Email__c");
		                	user.setMail(email);

		                	name = json.getJSONArray("records").getJSONObject(0).getString("Name");
		                	user.setUserName(name);
		                	                         

		                
		                System.out.println(" OBJET ::::: : Submission to revieuw "+user);

		                return user;
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
