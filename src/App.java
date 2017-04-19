import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;
import java.util.Random;
import model.Hangman;

public class App {

	public static void main(String[] args) {
		Hangman hangman = new Hangman();
		String letter;
		while (hangman.dashes() != hangman.getWord()) {
			System.out.println(hangman.getWord());
			Scanner input = new Scanner(System.in);
			letter = input.nextLine();
			System.out.println(letter);
			hangman.getUsedLetters().add(letter);
			System.out.println(hangman.dashes());
		}
		
		
		System.out.println(hangman.getUsedLetters());
		System.out.println(hangman.dashes());
	}
  	
    
}

