package persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.util.ArrayList;

public class CsvHandler {

    public static void main(String[] args) {

    }

    public static ArrayList <String> readFile(String filename) {

        FileReader fr = null;
        String line = "";
        ArrayList<String> wordsList = new ArrayList<String>();

        // opening file
        try {
         fr = new FileReader(filename);
        } catch (FileNotFoundException e) {
           System.out.println("Error while opening file!");
           System.exit(1);
        }

        BufferedReader bfr = new BufferedReader(fr);

        // reading file
        try {
         while((line = bfr.readLine()) != null){
            List<String> stringList = Arrays.asList(line.split(","));
            wordsList.add(stringList.get(1));

         }
        } catch (IOException e) {
            System.out.println("Error while reading file!");
            System.exit(2);
        }

        // closing file
        try {
         fr.close();
        } catch (IOException e) {
             System.out.println("Error while closing file!");
             System.exit(3);
            }
        return wordsList;
    }

    public static ArrayList<String> getWordListForLevel(String level) {

        String europe = "resources/europe.csv";
        String americas = "resources/americas.csv";
        String africa = "resources/africa.csv";

        ArrayList<String> wordsToReturn = readFile(europe);
        if (level.equals("easy")) {
        } else if (level.equals("medium")) {
            wordsToReturn.addAll(readFile(americas));
        } else if (level.equals("hard")) {
            wordsToReturn.addAll(readFile(americas));
            wordsToReturn.addAll(readFile(africa));
        }

        return wordsToReturn;
    }


}
