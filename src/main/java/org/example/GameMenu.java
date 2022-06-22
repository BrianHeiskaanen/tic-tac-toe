package org.example;

import java.util.Scanner;

public class GameMenu {
    public static void displayMainMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println(
                "1. Play with a friend \n" +
                "2. Play with a computer"
        );
        System.out.print("Enter the number: ");
        int input = in.nextInt();
        if(input == 1) menuOfPlayingWithAFriend();
        else if (input == 2) menuOfPlayingWithAComputer();
        else {
            System.out.println("There is no such item. Try again \n");
            displayMainMenu();
        }

        in.close();
    }

    private static void menuOfPlayingWithAFriend() {
        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter the name of 1 player: ");
        String inputNameOfTheFirstPlayer = in.nextLine();
        System.out.print("Enter the name of 2 player: ");
        String inputNameOfTheSecondPlayer = in.nextLine();
        GameLogicOfPlayingWithAFriend.Test(inputNameOfTheFirstPlayer, inputNameOfTheSecondPlayer);

        in.close();
    }

    private static void menuOfPlayingWithAComputer() {
        System.out.println("In development");
    }
}
