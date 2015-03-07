package ch08.ex08_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AccessProtectedSite {
  public static void main(String[] args) {
    URL url = null;
    try {
      url = new URL("***");
      URLConnection connection = url.openConnection();
      String auth = "username:password";
      Base64.Encoder encoder = Base64.getEncoder();
      String encodedString = encoder.encodeToString(auth.getBytes(StandardCharsets.UTF_8));
      connection.setRequestProperty("Authorization", "Basic " + encodedString);
      connection.connect();
      InputStream is = connection.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      String line;
      while((line = br.readLine()) != null) {
        System.out.println(line);
      }
      br.close();
    } catch (MalformedURLException mue) {
      mue.printStackTrace();
      System.err.println("Failed to create url");
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }



  }
}
