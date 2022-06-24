package org.example;

import java.util.Scanner;

public class GameLogicOfPlayingWithAFriend {
    private static char[] playingField = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static boolean winCheck = false;
    private static String displayPlayingField() {
        return (
                "|" + playingField[0] + "| " + "|" + playingField[1] + "| " + "|" + playingField[2] + "| \n" +
                        "|" + playingField[3] + "| " + "|" + playingField[4] + "| " + "|" + playingField[5] + "| \n" +
                        "|" + playingField[6] + "| " + "|" + playingField[7] + "| " + "|" + playingField[8] + "| \n"
        );
    }

    private static void choiceOfPlayerTurn(String nameOfTheFirstPlayer, String nameOfTheSecondPlayer) {
        Scanner in = new Scanner(System.in);

        for(int i = 0; i < 2; i++) {
            if(winCheck) break;

            String playerName = nameOfTheFirstPlayer;
            char playerSign = 'X';
            if(i == 1) {
                playerName = nameOfTheSecondPlayer;
                playerSign = 'O';
            }
            System.out.print("Player, " + playerName + " enter position number: ");
            int playerTurn = in.nextInt();
            if(playerTurn > 9 || playingField[playerTurn - 1] == 'X' || playingField[playerTurn - 1] == 'O') {
                i--;
                System.out.println();
                System.out.println("The position is occupied or does not exist. Choose another position");
            }
            else {
                playingField[playerTurn - 1] = playerSign;
            }
            System.out.println("-----------------------------------------------------");
            System.out.println(displayPlayingField());
        }
    }

    private static char winCheck() {
        if(playingField[0] == playingField[1] && playingField[0] == playingField[2]) {
            winCheck = true;
            return playingField[0];
        } else if (playingField[3] == playingField[4] && playingField[3] == playingField[5]) {
            winCheck = true;
            return playingField[3];
        } else if (playingField[6] == playingField[7] && playingField[6] == playingField[8]) {
            winCheck = true;
            return playingField[6];
        } else if (playingField[0] == playingField[3] && playingField[0] == playingField[6]) {
            winCheck = true;
            return playingField[0];
        } else if (playingField[1] == playingField[4] && playingField[1] == playingField[7]) {
            winCheck = true;
            return playingField[1];
        } else if (playingField[2] == playingField[5] && playingField[2] == playingField[8]) {
            winCheck = true;
            return playingField[2];
        } else if (playingField[0] == playingField[4] && playingField[0] == playingField[8]) {
            winCheck = true;
            return playingField[0];
        } else if (playingField[2] == playingField[4] && playingField[2] == playingField[6]) {
            winCheck = true;
            return playingField[2];
        } else if(playingField[0] != '1' &&
                playingField[1] != '2' &&
                playingField[2] != '3' &&
                playingField[3] != '4' &&
                playingField[4] != '5' &&
                playingField[5] != '6' &&
                playingField[6] != '7' &&
                playingField[7] != '8' &&
                playingField[8] != '9')
        {
            winCheck = true;
            return 1;
        }
        return 0;
    }

    public static void GameLogic(String nameOfTheFirstPlayer, String nameOfTheSecondPlayer) {
        System.out.println(displayPlayingField());
        while (true) {
            if(winCheck() == 'X') {
                System.out.println(nameOfTheFirstPlayer + " player won \n");
                break;
            } else if (winCheck() == 'O') {
                System.out.println(nameOfTheSecondPlayer+ ", player won \n");
                break;
            } else if (winCheck() == 1) {
                System.out.println("Draw \n");
                break;
            }
            choiceOfPlayerTurn(nameOfTheFirstPlayer, nameOfTheSecondPlayer);
        }

        for(int i = 0; i < 9; i++) {
            playingField[i] = (char)((i + 1) + '0');
        }
        winCheck = false;
        GameMenu.displayMainMenu();
    }
}
