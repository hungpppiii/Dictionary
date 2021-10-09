package dict;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Translate {
    private BufferedReader in = null;
    private StringBuilder response;

    public String translate(String text) {
        // INSERT YOU URL HERE
        try {
            String urlStr = "https://script.google.com/macros/s/AKfycbx96CKA4KgxTJPkXMjlV_U1m_cncgoCjFXC_z6YoTgwz-0hZsNl0aP9YM9JjyIpuyExNA/exec"
                    + "?q=" + URLEncoder.encode(text, "UTF-8") + "&target=vi&source=en";
            URL url = new URL(urlStr);
            response = new StringBuilder();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // if (response != null) {
            //     return response.toString();
            // }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }
}