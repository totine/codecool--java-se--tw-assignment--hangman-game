package view;

public class UI {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void showIncorrectOptionInputInfo(Integer optionsNumber) {
        System.out.println("Incorrect input! You should enter number between 1 and " + optionsNumber);
    }

    public static void showInfoAboutLevelsToChoice() {
        System.out.println("Option (1) - Easy \nOption (2) - Medium \nOption (3) - Hard");
        System.out.println("Choose level: ");
    }

    public static void showWrongLetterInputInfo(String letterInput) {
        System.out.println(letterInput + " is not valid letter. Try again.");
    }

    public static void showAskForLetterInput() {
        System.out.println("Input letter: ");
    }
}