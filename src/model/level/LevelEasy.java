package model.level;
import java.util.ArrayList;
import persistence.CsvHandler;

/**
 * Created by joanna on 20.04.17.
 */
public class LevelEasy extends Level {
    ArrayList<String> words = CsvHandler.getWordListForLevel("easy");

    public LevelEasy() {
        this.lives = 7;
        this.wordToGuess = getRandomWord();

    }


}
