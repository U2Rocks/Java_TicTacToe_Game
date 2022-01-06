package com.mycitrus;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // create list for tic tac toe values
        String[] ticList = new String[9];

        // assign default values to the new list
        for (int i = 0; i < 9; i++){
            ticList[i] = " ";
        }

        // print board for first time
        printBoard(ticList);

        // create player instances and game instance
        Player firstPlayer = new Player("X", true);
        Player secondPlayer = new Player("O", false);


        // create the scanner object
        Scanner ticScanner = new Scanner(System.in);

        // initialize variables before teh while loop
        int i = 0;
        int playerSelectionRaw = 0;
        int playerSelection = 0;

        // create while loop to manage game
        while (i < 10) {
            // tell program what to give user based on what user has a turn
            if (firstPlayer.getIsTurn()) {
                // get input from player and update board
                System.out.print("Player One(" + firstPlayer.getOutputLetter() +  ") choose a space(1-9): ");
                playerSelectionRaw = ticScanner.nextInt();
                playerSelection = playerSelectionRaw - 1;
                // prevent players from overriding an occupied space
                while (!ticList[playerSelection].equals(" ")){
                    System.out.print("Player One(" + firstPlayer.getOutputLetter() + ")please choose an empty space(1-9): ");
                    playerSelectionRaw = ticScanner.nextInt();
                    playerSelection = playerSelectionRaw - 1;
                }
                // call function to update board
                updateBoard(ticList, playerSelection, firstPlayer);

            } else {
                // get input from player and update board
                System.out.print("Player Two(" + secondPlayer.getOutputLetter() + ")choose a space(1-9): ");
                playerSelectionRaw = ticScanner.nextInt();
                playerSelection = playerSelectionRaw - 1;
                // prevent players from overriding an occupied space
                while (!ticList[playerSelection].equals(" ")){
                    System.out.print("Player Two(" + secondPlayer.getOutputLetter() + ")please choose an empty space(1-9): ");
                    playerSelectionRaw = ticScanner.nextInt();
                    playerSelection = playerSelectionRaw - 1;
                }
                // call function to update board
                updateBoard(ticList, playerSelection, secondPlayer);

            }


            // iterate variable for preventing infinite games and print out board after alterations
            i++;
            printBoard(ticList);

            // edge case ending if game is draw
            if (i == 9){
                System.out.println("The game is a draw!");
                break;
            }

            // check for winner and end while loop if winner found
            if (isWinner(ticList)){
                if (firstPlayer.getIsTurn()){
                    System.out.println("Congratulations on winning player one!");
                    break;
                } else {
                    System.out.println("Congratulations on winning player two!");
                    break;
                }
            }

            // swap player turns by updating objects
            firstPlayer.setIsTurn(!firstPlayer.getIsTurn());
            secondPlayer.setIsTurn(!secondPlayer.getIsTurn());
        }
    }

    public static void printBoard(String[] inputList) {
        // this function prints out the board given a list of strings
        System.out.println("------------");
        System.out.println(inputList[0] + " | " + inputList[1] + " | " + inputList[2]);
        System.out.println(inputList[3] + " | " + inputList[4] + " | " + inputList[5]);
        System.out.println(inputList[6] + " | " + inputList[7] + " | " + inputList[8]);
        System.out.println("------------");
    }

    public static void updateBoard(String[] inputList,int inputNum, Player playerObject){
        inputList[inputNum] = playerObject.getOutputLetter();
    }

    // this function tells us if someone has won
    public static boolean isWinner(String[] inputList){
        // using if statements to evaluate horizontal wins
        if (inputList[0].equals(inputList[1]) && inputList[1].equals(inputList[2])){
            if (!inputList[1].equals(" ")){
                return true;
            }
        }
        if (inputList[3].equals(inputList[4]) && inputList[4].equals(inputList[5])){
            if (!inputList[4].equals(" ")){
                return true;
            }
        }
        if (inputList[6].equals(inputList[7]) && inputList[7].equals(inputList[8])){
            if (!inputList[7].equals(" ")){
                return true;
            }
        }

        // using if statements to evaluate vertical wins
        if (inputList[0].equals(inputList[3]) && inputList[3].equals(inputList[6])){
            if (!inputList[3].equals(" ")){
                return true;
            }
        }
        if (inputList[1].equals(inputList[4]) && inputList[4].equals(inputList[7])){
            if (!inputList[4].equals(" ")){
                return true;
            }
        }
        if (inputList[2].equals(inputList[5]) && inputList[5].equals(inputList[8])){
            if (!inputList[5].equals(" ")){
                return true;
            }
        }

        // using if statements to evaluate diagonal wins
        if (inputList[0].equals(inputList[4]) && inputList[4].equals(inputList[8])){
            if (!inputList[4].equals(" ")){
                return true;
            }
        }
        if (inputList[2].equals(inputList[4]) && inputList[4].equals(inputList[6])){
            if (!inputList[4].equals(" ")){
                return true;
            }
        }

        return false; // default return in case no winners found
    }
}
