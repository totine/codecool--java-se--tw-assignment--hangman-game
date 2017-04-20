package model.level;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by joanna on 20.04.17.
 */
public class Level {
    Integer lives;
    String wordToGuess;
    ArrayList<String> words;

    public static String inputLevel() {
        String choosenLevel;
        do {
            System.out.println("Option (1) - Easy \nOption (2) - Medium \nOption (3) - Hard");
            System.out.println("Choose level: ");
            Scanner inputLevel = new Scanner(System.in);
            choosenLevel = inputLevel.nextLine();
        } while (choosenLevel.)
        return choosenLevel;
    }



    public String getRandomWord() {

        Random indexGenerator = new Random();
        return words.get(indexGenerator.nextInt(words.size()));
    }

    public Integer getLives(){
        return this.lives;
    }

    public String getWordToGuess(){
        return this.wordToGuess;
    }
}
