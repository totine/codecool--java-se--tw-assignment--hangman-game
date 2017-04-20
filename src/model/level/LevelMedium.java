package model.level;
import java.util.ArrayList;
import persistence.CsvHandler;
/**
 * Created by joanna on 20.04.17.
 */
public class LevelMedium extends Level {


    public LevelMedium() {
        this.words = CsvHandler.getWordListForLevel("medium");
        this.lives = 5;
        this.wordToGuess = getRandomWord();

    }
}
