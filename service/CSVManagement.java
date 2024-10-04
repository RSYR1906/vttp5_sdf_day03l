package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVManagement {

    // filename: dirPath + file separator + filename
    public void readCSV(String filename) throws IOException {

        // use BufferedReader
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println("Person details: " + line);
        }

        fr.close();
        br.close();
    }

    public void writeCSV(String filename) {

    }
}
