package utility;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import beans.Submission;

public class UtileSubmission {
	
	public static String submissionId;
	public static String baseUri;
	private static String loginAccessToken;
	private static Header oauthHeader;
	private static Header prettyPrintHeader = new BasicHeader("X-PrettyPrint", "1");

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
		s.put("Conference__c", "a000Y000009eL3K"); // en dur dans le code
		s.put("User__c", "a020Y000002Dc0I"); // en dur dans le code
		



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
				JSONObject json = new JSONObject(response_string);
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

		return null;
	
	}

}
