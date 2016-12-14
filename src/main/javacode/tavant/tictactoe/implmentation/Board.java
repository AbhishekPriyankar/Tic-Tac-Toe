package main.javacode.tavant.tictactoe.implmentation;

public class Board {
	private Player playerOne;
	private Player playerTwo;
	private char[][] gameBoard = new char[3][3];

	public Board(Player playerOne, Player playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		createBoard();
	}

	public char[][] getBoard() {
		return gameBoard;
	}

	private void createBoard() {
		int cellNumber = 1;
		for (int i = 0; i < 3; i++) {
			gameBoard[i][0] = (cellNumber + "").charAt(0);
			cellNumber++;
			gameBoard[i][1] = (cellNumber + "").charAt(0);
			cellNumber++;
			gameBoard[i][2] = (cellNumber + "").charAt(0);
			cellNumber++;
		}
	}

	public Boolean isAlreadyInserted(Character cellNumber) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (gameBoard[i][j] == cellNumber) {
					return false;
				}
			}
		}
		return true;
	}

	public void replaceCell(Character cellNumber, Player player) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (gameBoard[i][j] == cellNumber) {
					gameBoard[i][j] = player.getPlayerSymbol();
					break;
				}
			}
		}
	}

	public Boolean isPlayerXwinner(Player player) {
		Character playerSymbol = player.getPlayerSymbol();
		for (int i = 0; i < 3; i++) {
			if (gameBoard[i][0] == playerSymbol && gameBoard[i][1] == playerSymbol && gameBoard[i][2] == playerSymbol
					? true : false) 
				return Boolean.TRUE;
			if (gameBoard[0][i] == playerSymbol && gameBoard[1][i] == playerSymbol && gameBoard[2][i] == playerSymbol
					? true : false)
				return Boolean.TRUE;
			if (gameBoard[0][0] == playerSymbol && gameBoard[1][1] == playerSymbol && gameBoard[2][2] == playerSymbol
					? true : false)
				return Boolean.TRUE;
			if (gameBoard[2][0] == playerSymbol && gameBoard[1][1] == playerSymbol && gameBoard[0][2] == playerSymbol
					? true : false)
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public Boolean isGameDraw() {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int k = 0; k < gameBoard.length; k++) {
				if (!(gameBoard[i][k] == playerOne.getPlayerSymbol()
						|| gameBoard[i][k] == playerTwo.getPlayerSymbol())) {
					return false;
				}
			}
		}
		return true;
	}
}
