package LectureExamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        String dirPath = args[0];
        String fileName = args[1];

        // eg. c://data/myfile.txt
        String dirPathFileName = dirPath + File.separator + fileName;

        // check if a directory exists
        File directory = new File(dirPath);

        if (directory.exists()) {
            System.out.println("Directory " + directory.toString() + " had already been created");
        } else {
            directory.mkdir();
        }

        File file = new File(dirPathFileName);

        if (file.exists()) {
            System.out.println("File " + file.toString() + " had already been created");
        } else {
            file.createNewFile();
        }

        Console console = System.console();
        String keyBoardInput = console.readLine("Enter a sentence: ");

        // Example 1
        // Use FileWriter
        // 1. use console to read in a string of text (sentence)
        // 2. Use FileWriter to write the content of the file

        // FileWriter fw = new FileWriter(file, true);
        // fw.write(keyBoardInput);
        // fw.flush();
        // fw.close();

        // // Use FileReader to read file

        // FileReader fr = new FileReader(file);
        // int dataRead = fr.read();
        // while (dataRead != -1) {
        // System.out.print((char) dataRead);
        // dataRead = fr.read();
        // }
        // fr.close();

        // Example 2
        // Use BufferedWriter to write to file
        // FileWriter fw = new FileWriter(file, true);
        // BufferedWriter bw = new BufferedWriter(fw);
        // bw.append(keyBoardInput);
        // bw.flush();
        // bw.close();

        // // User BufferedReader to read file

        // FileReader fr = new FileReader(file);
        // BufferedReader br = new BufferedReader(fr);
        // String line = "";
        // while ((line = br.readLine()) != null) {
        // System.out.println(line);
        // }
        // br.close();
        // fr.close();

        // using try block instead of .close()
        // try (FileReader fr = new FileReader(file)) {
        // try (BufferedReader br = new BufferedReader(fr)) {
        // String line = "";
        // while ((line = br.readLine()) != null) {
        // System.out.println(line);
        // }
        // }
        // }

        // Example 3
        // Use FileOutputStream to write to file
        // FileOutputStream fos = new FileOutputStream(file,true);
        // byte[] byteContent = keyBoardInput.getBytes();

        // fos.write(byteContent);
        // fos.flush();
        // fos.close();

        // FileInputStream fis = new FileInputStream(file);
        // int contentRead = 0;
        // while ((contentRead = fis.read()) != -1){
        // System.out.print((char) contentRead);
        // }

        // fis.close();

        // Example 4 (Decorator pattern)
        // Use FileOutputStream and DataOutputStream to write to file
        FileOutputStream fos = new FileOutputStream(file, false);
        DataOutputStream dos = new DataOutputStream(fos);
        byte[] byteContent = keyBoardInput.getBytes();
        dos.write(byteContent);
        dos.flush();
        dos.close();
        fos.close();

        // Use FileInputStream and DataInputStream to read the content
        FileInputStream fis = new FileInputStream(file);
        DataInputStream dis = new DataInputStream(fis);
        int contentRead = 0;
        while ((contentRead = dis.read()) != -1) {
            System.out.println((char) contentRead);
        }
        dis.close();
        fis.close();

    }
}
