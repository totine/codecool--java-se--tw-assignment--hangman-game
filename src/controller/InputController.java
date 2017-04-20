package controller;

/**
 * Created by joanna on 20.04.17.
 */
public class InputController {
    public static Boolean IsValidOptionNumber(String optionToCheck, Integer maxOptionNumber) {
        return optionToCheck.matches("^\\d+$") && Integer.parseInt(optionToCheck) <= maxOptionNumber;
    }
}
