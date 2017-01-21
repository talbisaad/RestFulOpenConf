package ws;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ConnectRest {
		
	
	 static final String USERNAME     = "api-rest@univ-paris-saclay.fr";
	 static final String PASSWORD     = "Projetaos1K3JVLsAHlpzuRQpVSOujCWNu"; //password + security token
	 static final String LOGINURL     = "https://login.salesforce.com";
	 static final String GRANTSERVICE = "/services/oauth2/token?grant_type=password";
	 static final String CLIENTID     = "3MVG9HxRZv05HarRRFRhSMEOobtnGfBxQg1GEDjXxdp7VkPOUE8M1Rie6FjVnr7CGo_G66o8bJSjCLzHgVk_.";
	 static final String CLIENTSECRET = "833139723283330026";
	 
	    private static String REST_ENDPOINT = "/services/data" ;
	    private static String API_VERSION = "/v32.0" ;
	    private static String baseUri;
	    private static Header oauthHeader;

	public static JSONObject connect(){
		
	     
	     HttpClient httpclient = HttpClientBuilder.create().build();
	     
	        String loginURL = LOGINURL +
	                          GRANTSERVICE +
	                          "&client_id=" + CLIENTID +
	                          "&client_secret=" + CLIENTSECRET +
	                          "&username=" + USERNAME +
	                          "&password=" + PASSWORD;
	 
	        HttpPost httpPost = new HttpPost(loginURL);
	        HttpResponse response = null;
	 
	        try {
	            response = httpclient.execute(httpPost);
	        } catch (ClientProtocolException cpException) {
	            cpException.printStackTrace();
	        } catch (IOException ioException) {
	            ioException.printStackTrace();
	        }
	 
	        // verifier si  HTTP OK
	        final int statusCode = response.getStatusLine().getStatusCode();
	        if (statusCode != HttpStatus.SC_OK) {
	            System.out.println("erreur de force.com : "+statusCode);
	            JSONObject jsonError = new JSONObject();
	            jsonError.put("ERROR CODE", statusCode);
	            return jsonError;
	        }
	 
	        String getResult = null;
	        try {
	            getResult = EntityUtils.toString(response.getEntity());
	        } catch (IOException ioException) {
	            ioException.printStackTrace();
	        }
	 
	        JSONObject jsonObject = null;
	        String loginAccessToken = null;
	        String loginInstanceUrl = null;
	 
	        try {
	            jsonObject = (JSONObject) new JSONTokener(getResult).nextValue();
	            loginAccessToken = jsonObject.getString("access_token");
	            loginInstanceUrl = jsonObject.getString("instance_url");
	        } catch (JSONException jsonException) {
	            jsonException.printStackTrace();
	        }
	 
	        baseUri = loginInstanceUrl + REST_ENDPOINT + API_VERSION ;
	        oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken) ;
	        System.out.println("oauthHeader: " + oauthHeader);
	        System.out.println("\n" + response.getStatusLine());
	        System.out.println("instance URL: "+loginInstanceUrl);
	        System.out.println("access token/session ID: "+loginAccessToken);
	        System.out.println("baseUri: "+ baseUri);  
	        
	        JSONObject data = new JSONObject();
	        data.put("baseUri", baseUri);
	        data.put("loginAccessToken", loginAccessToken);
	        	        
	        
	        return data;
	}


}

