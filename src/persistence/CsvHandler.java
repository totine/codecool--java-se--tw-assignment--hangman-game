import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.io.BufferedReader;
import java.util.ArrayList;

public class CsvHandler {

    public static void main(String[] args) {
        readFile(filename);
    }

    public static List <String> readFile(String filename) {

        FileReader fr = null;
        String linia = "";
        List<String> wordsList = new ArrayList<String>();

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
         while((linia = bfr.readLine()) != null){
            List<String> stringList = Arrays.asList(linia.split(","));
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
        System.out.println(wordsList);
        return wordsList;
    }

    public ArrayList<String> getWordListForLevel(String level) {

        String europe = new String("../../resources/europe.csv");
        String americas = new String("../../resources/americas.csv");
        String africa = new String("../../resources/africa.csv");

        if (level == "easy"){
            return readFile(europe);
        } else if (level == "medium"){
            return readFile(europe).addAll(readFile(americas));
        } else if (level == "hard") {
            return readFile(europe).addAll(readFile(americas)).addAll(readFile(africa));
        }
    }


}
