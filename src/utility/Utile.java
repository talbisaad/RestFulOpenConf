package utility;

import java.io.IOException;
import java.io.Reader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.apache.http.Header;

import beans.User;

public class Utile {

	public static String userId;
	public static String baseUri;
	private static String loginAccessToken;
	private static Header oauthHeader;
	private static Header prettyPrintHeader = new BasicHeader("X-PrettyPrint", "1");

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
		u.put("Email__c", "testRest@gmail.com");

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
				System.out.println("ID  de new USER: " + userId + "");
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

}
