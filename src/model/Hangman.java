package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;
import java.util.Random;
import model.level.*;

public class Hangman {
	ArrayList<String> usedLetters = new ArrayList<String>();
	String word;
	Integer lives;
    
    public Hangman(Level level) {

    	this.word = level.getWordToGuess();
    	this.lives = level.getLives();
    }

    public String dashes() {
    	String used = String.join("", usedLetters);
    	Pattern p = Pattern.compile("[^ '"+ used + "]", Pattern.CASE_INSENSITIVE);
    	return p.matcher(this.word).replaceAll("_ ");
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

    public void removeLive () {
        this.lives--;
    }
}