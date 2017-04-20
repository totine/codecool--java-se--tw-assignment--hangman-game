import java.util.Scanner;

import model.Hangman;
import model.Player;
import model.level.*;
import view.UI;


public class App {
    private static Boolean isCheat = false;
    private Level level;
    private Hangman hangman;
    private Player player;
    private Boolean isContinue;

    private App(Player player, Level level) {
        this.level = level;
        this.hangman = new Hangman(this.level);
        this.player = player;
        this.isContinue = true;
    }

    private void gameLoop() {
        String option;
        String letter;
        String word = "";
        UI.clearScreen();
        sayHelloToPlayer();

        while (!hangman.dashes().equals(hangman.getWord()) && hangman.getLives() > 0 && !hangman.getWord().equals(word)) {
            if (isCheat)
                System.out.println("cheat: " + hangman.getWord());
            System.out.println("Your chances: " + hangman.getLives());
            if (hangman.getUsedLetters().size() != 0){
                System.out.println("Letters you already used: " + hangman.getUsedLettersInPrettyForm());
            }
            System.out.println(hangman.dashes());

            System.out.println("Option (1) - input letter \nOption (2) - input all word");
            Scanner input = new Scanner(System.in);
            option = input.nextLine();

            if (option.equals("1")) {
                System.out.println("Input letter: ");
                Scanner inputLetter = new Scanner(System.in);
                letter = inputLetter.nextLine();
                if (!hangman.getWord().contains(letter.toUpperCase()))
                    hangman.removeLive();
                hangman.addLetterToUsedLetter(letter);

            }
            if (option.equals("2")) {
                System.out.println("Try to guess all word: ");
                Scanner inputWord = new Scanner(System.in);
                word = inputWord.nextLine().toUpperCase();
                if (!hangman.getWord().equals(word))
                    hangman.removeLive();

            }
            UI.clearScreen();
        }



        if (hangman.getLives() == 0) {
            System.out.println("You lost!");
            System.out.println("Correct word is " + hangman.getWord());
        } else {
            System.out.println(hangman.dashes());
            System.out.println("You win!");
        }
        System.out.println("Continue? y/n");
        Scanner inputIsContinue = new Scanner(System.in);
        String isContinue = inputIsContinue.nextLine().toLowerCase().trim();
        if (isContinue.equals("n")) {
            this.isContinue = false;
            System.out.println("See you next time!");
        } else {
            level = chooseLevel();
            setHangman(level);
        }
    }

    private static Level chooseLevel() {
        String choosenLevel = Level.inputLevel();
        Level level = new LevelEasy();
        switch (choosenLevel) {
            case "1":
                level = new LevelEasy();
                break;
            case "2":
                level = new LevelMedium();
                break;
            case "3":
                level = new LevelHard();
                break;
        }
        return level;
    }

    private void sayHelloToPlayer(){
        System.out.println("Hello, " + this.player.getName());
    }

    private void setHangman(Level level) {
        this.hangman = new Hangman(level);
    }

    private Boolean getIsContinue() {
        return this.isContinue;
    }

    public static void main(String[] args) {
        if (args.length>0 && args[0].trim().equals("cheat") ) {
            isCheat = true;
        }
        Player player = Player.addNewPlayer();
        Level level = chooseLevel();
        App game = new App(player, level);
        while (game.getIsContinue()) {
            game.gameLoop();
        }


    }


}
