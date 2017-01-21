package utility;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beans.Submission;

public  class UtileSubmission {
	
	public static ArrayList<Submission> submissionList = new ArrayList<Submission>();
	public static Submission submission;
	
	public  static ArrayList<String> submissionThemes= new ArrayList<String>();
	private static JSONObject json;
	
	public static String submissionId;
	public static String name;
	public static String theme;
	public static String subject;
	public static String baseUri;
	private static String loginAccessToken;
	private static Header oauthHeader;
	private static Header prettyPrintHeader = new BasicHeader("X-PrettyPrint", "1");
	

	
	
	public static ArrayList<Submission> getsubmissionList(String conferenceName, JSONObject data) {
		
        
		try {
			baseUri = data.getString("baseUri");
			System.out.println("DATA --> " + baseUri);
			loginAccessToken = data.getString("loginAccessToken");
		} catch (JSONException jsonException) {
			jsonException.printStackTrace();
		}

		oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken);
		if(submissionList!=null)
			submissionList.clear();
		try{
        HttpClient httpClient = HttpClientBuilder.create().build();
		String uri = baseUri + "/query?q=Select+Id+,+Name+,+Subject__c+From+Submission__c+where+Conference__r.subject__c='"+conferenceName+"'";
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
                	submission= new Submission();

                	submissionId = json.getJSONArray("records").getJSONObject(i).getString("Id");
                	submission.setIdSubmission(submissionId);
                	
                	name = json.getJSONArray("records").getJSONObject(i).getString("Name");
                	submission.setSubmissionTitle(name);

                	subject = json.getJSONArray("records").getJSONObject(i).getString("Subject__c");
                	submission.setSubmissionTitle(subject);
                	
                    submissionList.add(submission);
                	
                    System.out.println("conference submission is: " + i + ". " + submissionId + " " + name + " " + subject +" ");
                }
                
                System.out.println("list conf --> Utilconference "+submissionList);

                return submissionList;
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

	

	
	public static Submission getsubmissionToReview(String idSubmission, JSONObject data) {
		
        
		try {
			baseUri = data.getString("baseUri");
			System.out.println("DATA --> " + baseUri);
			loginAccessToken = data.getString("loginAccessToken");
		} catch (JSONException jsonException) {
			jsonException.printStackTrace();
		}

		oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken);
		if(submissionList!=null)
			submissionList.clear();
		try{
        HttpClient httpClient = HttpClientBuilder.create().build();
		String uri = baseUri + "/query?q=Select+Id+,+Name+,+Subject__c+From+Submission__c+where+Id='"+idSubmission+"'";
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
                
                	submission= new Submission();

                	submissionId = json.getJSONArray("records").getJSONObject(0).getString("Id");
                	submission.setIdSubmission(submissionId);
                	
                	name = json.getJSONArray("records").getJSONObject(0).getString("Name");
                	submission.setSubmissionTitle(name);

                	theme = json.getJSONArray("records").getJSONObject(0).getString("Subject__c");
                	submission.setSubmissionTheme(subject);
                	                         
                
                System.out.println(" OBJET ::::: : Submission to revieuw "+submission);

                return submission;
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

	

	
	
	

	public static JSONObject addSubmission(Submission submission, JSONObject data) {
		
		
		try {
			baseUri = data.getString("baseUri");
			System.out.println("DATA --> " + baseUri);
			loginAccessToken = data.getString("loginAccessToken");
		} catch (JSONException jsonException) {
			jsonException.printStackTrace();
		}

		oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken);
		
		String uri = baseUri + "/sobjects/Submission__c/";

		JSONObject s = new JSONObject();
		s.put("Name", submission.getSubmissionTitle());
		s.put("keywords__c", submission.getKeywords());
		s.put("Conference__c","a000Y000009eL3K" ); // en dur dans le code
		s.put("User__c", "a020Y000002Dc0I"); // en dur dans le code dans l'attente de récuprer via les sessions
		

		try {
			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpPost httpPost = new HttpPost(uri);
			httpPost.addHeader(oauthHeader);
			httpPost.addHeader(prettyPrintHeader);

			StringEntity body = new StringEntity(s.toString(1));
			body.setContentType("application/json");
			httpPost.setEntity(body);

			// Allons-y !
			HttpResponse response = httpClient.execute(httpPost);
			// Process the results
			int statusCode = response.getStatusLine().getStatusCode();
			
			if (statusCode == 201) {
				String response_string = EntityUtils.toString(response.getEntity());
			  json = new JSONObject(response_string);
				// get ID of new record has been added 
				submissionId = json.getString("id");
				System.out.println("ID  de new SUB: " + submissionId );
			} else {
				System.out.println("FAILED ERROR CODE  " + statusCode);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}

		return json;
	
	}

	
	
// a tester
	public static JSONObject updateSubmissionByReviewer(Submission submission, JSONObject data) {
		
		System.out.println(" ++++ JE SUIS DANS updateSubmissionByReviewer " + baseUri);

		try {
			baseUri = data.getString("baseUri");
			System.out.println("DATA --> " + baseUri);
			loginAccessToken = data.getString("loginAccessToken");
		} catch (JSONException jsonException) {
			jsonException.printStackTrace();
		}

		oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken);
		
		String uri = baseUri + "/sobjects/Submission__c/"+submissionId;

		JSONObject s = new JSONObject();
		s.put("Descison__c", submission.getStatus());
		s.put("Comment__c", submission.getReviewComments());
		s.put("Grad__c", submission.getGrad());
		
		System.out.println("MON JSON ++" + s);

		
		
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpPatch httpPatch = new HttpPatch(uri); // HttpPatch cest pour faire un update basant sur l'Id de record 
            httpPatch.addHeader(oauthHeader);
            httpPatch.addHeader(prettyPrintHeader);
            StringEntity body = new StringEntity(s.toString(1));
            body.setContentType("application/json");
            httpPatch.setEntity(body);
 
            HttpResponse response = httpClient.execute(httpPatch);
 
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 204) {
                System.out.println("Update submission successfully ==updateSubmissionByReviewer== ");
            } else {
                System.out.println("OPPS!! ERROR , CODE :  " + statusCode);
            }
        } catch (JSONException e) {
            System.out.println("Problem de JSON ou autre");
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

		return null;
	
	}


 // a tester 
	public static JSONObject updateSubmission(String submissionId, JSONObject data) {
		
		
		try {
			baseUri = data.getString("baseUri");
			System.out.println("DATA --> " + baseUri);
			loginAccessToken = data.getString("loginAccessToken");
		} catch (JSONException jsonException) {
			jsonException.printStackTrace();
		}

		oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken);
		
		String uri = baseUri + "/sobjects/Submission__c/"+submissionId;

		JSONObject s = new JSONObject();
		
		
		
		
		s.put("submissionAbstract__c", submission.getSubmissionAbstract());
		s.put("Subject__c", submission.getSubmissionTheme()); // a modifer
		s.put("Abstract__c", submission.getSubmissionAbstract());
		
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpPatch httpPatch = new HttpPatch(uri); // HttpPatch cest pour faire un update basant sur l'Id de record 
            httpPatch.addHeader(oauthHeader);
            httpPatch.addHeader(prettyPrintHeader);
            StringEntity body = new StringEntity(s.toString(1));
            body.setContentType("application/json");
            httpPatch.setEntity(body);
 
            HttpResponse response = httpClient.execute(httpPatch);
 
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 204) {
                System.out.println("Upload submission successfully ");
            } else {
                System.out.println("OPPS!! ERROR , CODE :  " + statusCode);
            }
        } catch (JSONException e) {
            System.out.println("Problem de JSON ou autre");
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

		return null;
	
	}
	
	
	
	public static void deleteSubmission(String idToDelete, JSONObject data){
		
		
		 
        String uri = baseUri + "/sobjects/Submission__c/" + idToDelete;
        
        
		try {
			baseUri = data.getString("baseUri");
			System.out.println("DATA --> " + baseUri);
			loginAccessToken = data.getString("loginAccessToken");
		} catch (JSONException jsonException) {
			jsonException.printStackTrace();
		}

        
        
        try {
            //Set up the objects necessary to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();
 
            HttpDelete httpDelete = new HttpDelete(uri);
            httpDelete.addHeader(oauthHeader);
            httpDelete.addHeader(prettyPrintHeader);
 
            //Make the request
            HttpResponse response = httpClient.execute(httpDelete);
 
            //Process the response
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 204) {
                System.out.println("suppression est OK.");
            } else {
                System.out.println("ERROR CODE  " + statusCode);
            }
        } catch (JSONException e) {
            System.out.println("PROBLEME DE JSON");
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
		
		
		
	}
	
	public static 	ArrayList<String> getSubmissionsThemes(){
	submissionThemes.add("Programming");
	submissionThemes.add("Classic papers");
	submissionThemes.add("Networking");
	submissionThemes.add("Computer science");
		return submissionThemes;
	}
	

	

}
