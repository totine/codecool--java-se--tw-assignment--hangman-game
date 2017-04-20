package model.level;
import java.util.ArrayList;
import persistence.CsvHandler;
/**
 * Created by joanna on 20.04.17.
 */
public class LevelMedium extends Level {
    ArrayList<String> words = CsvHandler.getWordListForLevel("medium");

    public LevelMedium() {
        this.lives = 5;
        this.wordToGuess = getRandomWord();

    }
}
