package security;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sameenislam on 23/09/2016.
 */
public class Utility {

    public static String readFileContents(File openedFile) throws IOException {
        FileReader reader = new FileReader(openedFile);
        BufferedReader br = new BufferedReader(reader);
        String fullText = "";
        String line = br.readLine();
        while(line != null) {
            fullText += line;
            line = br.readLine();
        }

        return fullText;
    }

}
