package main.javacode.tavant.tictactoe.implmentation;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Game {
	private Player playerOne;
	private Player playerTwo;
	private Scanner input = new Scanner(System.in);
	private GameBoard board;
	private char[][] gameBoard = new char[3][3];
	private Character cellChoice;
	private Boolean exit = Boolean.FALSE;
	private boolean playerOneChance;
	private boolean finish = false;

	public void startGame() {
		System.out.println("Enter your Player Names ");
		System.out.print("Player 1 : ");
		playerOne = new Player(input.next(), 'X');
		System.out.print("Player 2 : ");
		playerTwo = new Player(input.next(), 'O');
		while (!finish) {
			finish = true;
			exit = false;
			board = new GameBoard(playerOne, playerTwo);
			while (!exit) {
				System.out.println("Game tic tac Toe starts ");
				gameBoard = board.getBoard();
				displayBoard();
				System.out.println(StringUtils.repeat("-", 19));
				callPlayer(playerOne);
				if (board.isGameDraw()) {
					System.out.println("Game Draw!!!");
					displayBoard();
					exit = Boolean.TRUE;
				}
				if (!exit) {
					displayBoard();
					System.out.println(StringUtils.repeat("-", 19));
					callPlayer(playerTwo);
				}
			}
			System.out.println("Play again ? Y / N");
			Character playAgain = input.next().charAt(0);
			if (playAgain.toString().equalsIgnoreCase("y")) {
				finish = false;
			}
		}
	}

	public void callPlayer(Player playerInstance) {
		do {
			playerOneChance = true;
			System.out.println("Player : " + playerInstance.getPlayerName() + "'s Turn - Select cell");
			cellChoice = input.next().charAt(0);
			if (!board.isAlreadyInserted(cellChoice)) {
				board.replaceCell(cellChoice, playerInstance);
				if (board.isPlayerXwinner(playerInstance)) {
					System.out.println("WINNER : " + playerInstance.getPlayerName());
					exit = Boolean.TRUE;
				}
			} else {
				System.out.println("Cell occupuied");
				playerOneChance = false;
			}
		} while (!playerOneChance);
	}

	public void displayBoard() {
		for (int i = 0; i < gameBoard.length; i++) {
			System.out.println(StringUtils.repeat("-", 19));
			System.out.print("|" + StringUtils.repeat(" ", 2) + gameBoard[i][0] + StringUtils.repeat(" ", 2));
			System.out.print("|" + StringUtils.repeat(" ", 2) + gameBoard[i][1] + StringUtils.repeat(" ", 2));
			System.out.print("|" + StringUtils.repeat(" ", 2) + gameBoard[i][2] + StringUtils.repeat(" ", 2) + "|");
			System.out.println();
		}
	}
}
