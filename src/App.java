import java.util.Scanner;

import controller.InputController;
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
        String word = "";
        UI.clearScreen();
        sayHelloToPlayer();

        while (!hangman.dashes().equals(hangman.getWord()) && hangman.getLives() > 0 && !hangman.getWord().equals(word)) {
            if (isCheat)
                System.out.println("cheat: " + hangman.getWord());
            showHangmanInfo();
            option = askForTryOption();
            switch (option) {
                case "1":
                    letterTry();
                    break;
                case "2":
                    word = wordAnswer();
                    break;
            }
        }
        if (hangman.getLives() == 0)
            showLostInfo();
        else
            showWinInfo();
        askAboutContinueGame();
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

    private void showHangmanInfo() {
        System.out.println("Your chances: " + hangman.getLives());
        if (hangman.getUsedLetters().size() != 0){
            System.out.println("Letters you already used: " + hangman.getUsedLettersInPrettyFormWithCommas());
        }
        System.out.println(hangman.dashes());
    }

    private void letterTry() {
        UI.showAskForLetterInput();
        Scanner inputLetter = new Scanner(System.in);
        String letter = inputLetter.nextLine().trim();
        while (! InputController.isValidLetterTry(letter) || hangman.getUsedLettersInStringForm().contains(letter.toUpperCase())) {
            if (! InputController.isValidLetterTry(letter))
                UI.showWrongLetterInputInfo(letter);
            else if (hangman.getUsedLettersInStringForm().contains(letter.toUpperCase()))
                System.out.println("You used letter " + letter.toUpperCase() + " before. Try again");
            UI.showAskForLetterInput();
            letter = inputLetter.nextLine().trim().toUpperCase();

        }

        if (!hangman.getWord().contains(letter.toUpperCase())) {
            hangman.removeLive();
            showWrongLetterInfo(letter);
        }

        hangman.addLetterToUsedLetter(letter);

    }

    private String wordAnswer() {
        System.out.println("Try to guess all word: ");
        Scanner inputWord = new Scanner(System.in);
        String word = inputWord.nextLine().toUpperCase();
        while (!InputController.isValidFullWordAnswer(word)){
            System.out.println("Answer should be longer than 2 letter and should contain only letters, spaces and apostrophes. Try again: ");
            word = inputWord.nextLine().toUpperCase();
        }
        if (!hangman.getWord().equals(word))
            hangman.removeLive();
        return word;
    }

    private void sayHelloToPlayer(){
        System.out.println("Hello, " + this.player.getName());
    }

    private String askForTryOption(){
        System.out.println("Option (1) - input letter \nOption (2) - input all word");
        Scanner inputOption = new Scanner(System.in);
        String option = inputOption.nextLine();
        while (!InputController.isValidOptionNumber(option, 2)){
            UI.showIncorrectOptionInputInfo(2);
            option = inputOption.nextLine();
        }

        return option;
    }

    private void showWrongLetterInfo(String letter) {
        System.out.println("Letter " + letter.toUpperCase() + " is not in word to guess. You've lost 1 live.");
        if (hangman.getLives() > 0)
            System.out.println("Try again");
    }

    private void showWinInfo() {
        System.out.println("You win!");
    }

    private void showLostInfo() {
        System.out.println("You lost!");
        System.out.println("Correct word is " + hangman.getWord());
    }

    private void askAboutContinueGame() {
        System.out.println("Continue? y/n");
        Scanner inputIsContinue = new Scanner(System.in);
        String isContinueAnswer = inputIsContinue.nextLine().toLowerCase().trim();
        while (!InputController.isValidYesNoAnswer(isContinueAnswer)){
            System.out.println("You should enter 'y' or 'n' only. Try again.");
            isContinueAnswer = inputIsContinue.nextLine().toLowerCase().trim();
        }

        if (isContinueAnswer.equals("n")) {
            this.isContinue = false;
            System.out.println("See you next time!");
        } else {
            level = chooseLevel();
            setHangman(level);
        }
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
        UI.clearScreen();
        Player player = Player.addNewPlayer();
        Level level = chooseLevel();
        App game = new App(player, level);
        while (game.getIsContinue()) {
            game.gameLoop();
        }
    }
}
