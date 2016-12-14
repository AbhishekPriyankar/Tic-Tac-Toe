package com.tavant.task.tictac;

import java.util.Scanner;

public class StartTicTacToe {

	private static Scanner input;

	public static void main(String[] args) {
		char player = 'o';
		int row, column;
		input = new Scanner(System.in);
		Game gameInstance = new Game();

		gameInstance.initializeGame();
		System.out.println("Game ready !\n");

		while (true) {
			player = gameInstance.changePlayer(player);
			System.out.print("\n" + player + " ,choose your location (row, column):");
			row = input.nextInt();
			column = input.nextInt();

			while (gameInstance.checkIfLegal(row, column)) {
				System.out.println("That slot is already taken or out of bounds, please try again (row, column).");
				gameInstance.displayBoard();
				row = input.nextInt();
				column = input.nextInt();
			}
			gameInstance.changeBoard(player, row, column);
			gameInstance.displayBoard();

			if (gameInstance.checkIfWinner()) {
				System.out.println("\nThe winner is " + player + " !");
				break;

			}
			if (gameInstance.checkIfTie()) {
				System.out.println("\nThe game is a tie !");
				break;
			}
		}

	}

}