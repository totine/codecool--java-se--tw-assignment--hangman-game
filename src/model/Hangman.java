package model;

import java.util.ArrayList;
import java.util.regex.*;
import model.level.*;

public class Hangman {
	private ArrayList<String> usedLetters = new ArrayList<>();
    private String word;
    private Integer lives;
    
    public Hangman(Level level) {

    	this.word = level.getWordToGuess();
    	this.lives = level.getLives();
    }

    public String dashes() {
    	String used = String.join("", usedLetters);
    	Pattern p = Pattern.compile("[^ '"+ used + "]", Pattern.CASE_INSENSITIVE);
    	return p.matcher(this.word).replaceAll("_");
    }

    public String getWord() {
        return this.word;

    }

    public Integer getLives() {
        return this.lives;
    }

    public ArrayList<String> getUsedLetters() {
        return this.usedLetters;
    }

    public String getUsedLettersInStringForm() {
        return String.join("", this.usedLetters);
    }

    public String getUsedLettersInPrettyForm() {
        this.usedLetters.sort(String::compareToIgnoreCase);
        return String.join(", ", this.usedLetters );
    }

    public void removeLive () {
        this.lives--;
    }

    public void addLetterToUsedLetter(String letter) {
        this.usedLetters.add(letter.toUpperCase());
    }
}