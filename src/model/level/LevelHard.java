package model.level;
import java.util.ArrayList;
 import persistence.CsvHandler;
/**
 * Created by joanna on 20.04.17.
 */
public class LevelHard extends Level {
    ArrayList<String> words = CsvHandler.getWordListForLevel("hard");

    public LevelHard() {
        this.lives = 3;
        this.wordToGuess = getRandomWord();

    }
}
