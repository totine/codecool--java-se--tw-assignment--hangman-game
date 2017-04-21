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
}
