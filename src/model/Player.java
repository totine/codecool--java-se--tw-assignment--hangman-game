package model;

import java.util.Scanner;

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
         String name = inputPlayerName();
         return new Player(name);

    }

    public String getName() {
         return this.name;
    }
}
