package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Scanner;

/*
 * Application controller: conducts the overall flow of the app, does all user prompting and passes user provided info into the backend model.
 *
 */

public class DuckRaceApp {
    private final Scanner scanner = new Scanner(System.in);
    private Board board = new Board();

    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
    }

    private int promptForId() {
        int id = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter ID of the winner [1-11]: "); // to don't hardcode 11
            String input = scanner.nextLine().trim(); // Blocks for [Enter]
            if (input.matches("\\d{1,2}")) {
                id = Integer.parseInt(input);
                if (id >= 1 && id <= 11) {
                    validInput = true;
                }
            }
        }
        return id;
    }

    private Reward promptForReward() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine(); // blocks for [enter]

            if (input.matches("D|P")){
                reward = (input.equals("D"))? Reward.DEBIT_CARD : Reward.PRIZES;
                validInput = true;
            }
            }

        return reward;
    }

    private void updateBoard(int id, Reward reward) {
    }

    private void showBoard() {
    }

    private void welcome() {
        System.out.print("\n");
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
        System.out.println("Welcome to Duck Race!");
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
        System.out.println("\n");
    }
}
