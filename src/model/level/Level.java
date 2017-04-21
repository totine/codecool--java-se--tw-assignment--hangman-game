package model.level;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import controller.InputController;
import view.UI;

/**
 * Created by joanna on 20.04.17.
 */
public class Level {
    Integer lives;
    String wordToGuess;
    ArrayList<String> words;

    public static String inputLevel() {
        String choosenLevel;
        UI.showInfoAboutLevelsToChoice();
        Scanner inputLevel = new Scanner(System.in);
        choosenLevel = inputLevel.nextLine().trim();
        while (!InputController.isValidOptionNumber(choosenLevel, 3)) {
            UI.showIncorrectOptionInputInfo(3);
            UI.showInfoAboutLevelsToChoice();
            choosenLevel = inputLevel.nextLine().trim();
        }
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
