package model.level;
import java.util.ArrayList;
 import persistence.CsvHandler;
/**
 * Created by joanna on 20.04.17.
 */
public class LevelHard extends Level {


    public LevelHard() {
        this.words = CsvHandler.getWordListForLevel("hard");
        this.lives = 3;
        this.wordToGuess = getRandomWord();

    }
}
