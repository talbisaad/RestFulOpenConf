package ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.http.client.HttpClient;
import org.json.JSONObject;

public class UploadFile {
	
	public static int uplaodFile(String path, String title, String description,PrintWriter writer, JSONObject data) {
		
		byte[] datafile = readBytesFromFile(path);
        //HttpClient httpclient = new HttpClient();

        JSONObject content = new JSONObject();
		
		
		
		

		return 1;// return server code;
		
		
		
		
	}
	
	private static byte[] readBytesFromFile(String filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {

            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return bytesArray;

    }

}
