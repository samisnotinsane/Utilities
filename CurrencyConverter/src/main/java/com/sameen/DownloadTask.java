package main.java.com.sameen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sameen on 09/08/2016.
 */
public class DownloadTask {

    // Query API and get JSON response
    private static String downloadData() {
        // Perform GET http://api.fixer.io/latest?base=GBP
        String data = "";
        try {
            URL fixerApi = new URL("http", "api.fixer.io", "/latest?base=GBP");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(fixerApi.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
                data += data;
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // parse downloaded JSON for required currency
    private static void parseRate(String str, String cur) {
        char[] strChars = str.toCharArray();
        char[] curChars = cur.toCharArray();
        for(int i=0; i<strChars.length; i++) {

        }
    }

    // returns current EUR against base GBP rate
    public static String getEur() {
        return "ELLO M88!";
    }


    public static void main(String[] args) {
        String data  = downloadData();
        parseRate(data, "EUR");
    }

}
