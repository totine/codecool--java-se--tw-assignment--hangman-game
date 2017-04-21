package controller;

/**
 * Created by joanna on 20.04.17.
 */
public class InputController {
    public static Boolean isValidOptionNumber(String optionToCheck, Integer maxOptionNumber) {
        return optionToCheck.matches("^\\d+$") && Integer.parseInt(optionToCheck) <= maxOptionNumber;
    }

    public static Boolean isValidName(String nameToCheck) {
        return nameToCheck.matches("^\\w{3,}$");
    }

    public static Boolean isValidLetterTry(String letterInputToCheck) {
        return letterInputToCheck.matches("^[A-Za-z]$");
    }

    public static Boolean isValidYesNoAnswer(String yesNoAnswerToCheck) {
        return yesNoAnswerToCheck.matches("^[YNyn]$");
    }

    public static Boolean isValidFullWordAnswer(String fullWordAnswer) {
        return fullWordAnswer.matches("^[A-Za-z ']{3,}$");
    }
}
