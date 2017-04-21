package model;

import java.util.Scanner;
import controller.InputController;
import view.UI;

public class Player {
     String name;

     public Player(String name) {
         this.name = name;
    }

    public static String inputPlayerName() {
        System.out.println("Enter player name: ");
        Scanner inputName = new Scanner(System.in);
        return inputName.nextLine();
    }

    public static Player addNewPlayer() {
         String name = inputPlayerName().trim();
         while (!InputController.isValidName(name)) {
             UI.clearScreen();
             System.out.println("Name should have almost 3 letters or digits or underscore (no spaces and special chars allowed). Try again.");
             name = inputPlayerName().trim();
         }
         return new Player(name);

    }

    public String getName() {
         return this.name;
    }
}
