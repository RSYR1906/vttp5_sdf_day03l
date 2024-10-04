package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import people.Person;

public class CSVManagement {

    // filename: dirPath + file separator + filename
    public ArrayList<Person> readCSV(String filename) throws IOException {

        // use BufferedReader
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        ArrayList<Person> persons = new ArrayList<>();
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);

            // lineData[0], lineData[1], lineData[2]
            String[] lineData = line.split(", ");

            // put the extracted line data into a Person object
            Person p = new Person(lineData[0], lineData[1], Integer.parseInt(lineData[2]));
            persons.add(p);
        }

        fr.close();
        br.close();

        return persons;
    }

    public void writeCSV(String fullDirPathFilename, ArrayList<Person> persons) throws IOException {

        // Use BufferedWriter

        FileWriter fw = new FileWriter(fullDirPathFilename, false);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Person p : persons) {
            bw.append(p.getName());
            bw.append(",");
            bw.append(p.getRegion());
            bw.append(",");
            bw.append(String.valueOf(p.getYearOfBirth()));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        fw.close();
    }
}
