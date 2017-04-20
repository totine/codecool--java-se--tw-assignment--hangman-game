package model.level;
import java.util.ArrayList;
import persistence.CsvHandler;

/**
 * Created by joanna on 20.04.17.
 */
public class LevelEasy extends Level {


    public LevelEasy() {
        this.words = CsvHandler.getWordListForLevel("easy");
        this.lives = 7;
        this.wordToGuess = getRandomWord();

    }


}
