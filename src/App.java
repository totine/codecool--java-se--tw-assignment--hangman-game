import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;
import java.util.Random;
import model.Hangman;
import model.Player;

public class App {
	private Hangman hangman;
	Player player;
	Boolean isContinue;

	private App(Player player){
		this.hangman = new Hangman();
		this.player = player;
		this.isContinue = true;
	}

	private void gameLoop() {
        String option;
        String letter;
        String word = "";
        while (hangman.dashes() != hangman.getWord() && hangman.getLives() > 0 && !hangman.getWord().equals(word)) {
            System.out.println(hangman.getWord());
            System.out.println("Hello, " + this.player.getName());
            System.out.println("Option (1) - input letter \nOption (2) - input all word");
            Scanner input = new Scanner(System.in);
            option = input.nextLine();
            System.out.println(option);

            if (option.equals("1")) {
                System.out.println("Input letter: ");
                Scanner inputLetter = new Scanner(System.in);
                letter = inputLetter.nextLine();
                if (!hangman.getWord().contains(letter.toUpperCase()))
                    hangman.removeLive();
                System.out.println(letter);
                hangman.getUsedLetters().add(letter);


            }
            if (option.equals("2")) {
                System.out.println("Try to guess all word: ");
                Scanner inputWord = new Scanner(System.in);
                word = inputWord.nextLine().toUpperCase();
                if (hangman.getWord() != word)
                    hangman.removeLive();
                System.out.println(word);


            }
            System.out.println(hangman.dashes());
            System.out.println(hangman.getLives());

        }


        System.out.println(hangman.getUsedLetters());
        System.out.println(hangman.dashes());
        if (hangman.getLives() == 0) {
            System.out.println("You lost!");
            System.out.println("Correct word is " + hangman.getWord());
        } else {
            System.out.println("You win!");
        }
        System.out.println("Continue? y/n");
        Scanner inputIsContinue = new Scanner(System.in);
        String isContinue = inputIsContinue.nextLine().toLowerCase().trim();
        if (isContinue.equals("n")) {
            this.isContinue = false;
            System.out.println("See you next time!");
        }
    }

	public static void main(String[] args) {
	    String playerName = Player.inputPlayerName();
	    Player player = new Player(playerName);
	    App game = new App(player);
	    while (game.isContinue) {
            game.gameLoop();
        }


	}

    
}
