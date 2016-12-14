package javatest.tavant.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;
import main.javacode.tavant.tictactoe.implmentation.Board;
import main.javacode.tavant.tictactoe.implmentation.Player;

public class BoardTest {

	@Test
	public void testIsAlreadyInserted() {
		// Arrange
		Board board = new Board(new Player("Player1", 'X'), new Player("Player2", 'O'));
		Boolean expected = false;
		Boolean actual;

		// Act
		actual = board.isAlreadyInserted('1');

		// Assert
		assertEquals(expected, actual);

		// Arrange when the cell is already inserted
		Player playerOne = new Player("Player1", 'X');
		Player playerTwo = new Player("Player1", 'O');
		board = new Board(playerOne, playerTwo);
		expected = true;

		// Act
		board.replaceCell('1', playerTwo);
		actual = board.isAlreadyInserted('1');

		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void testReplaceCell() {
		// Arrange
		Player playerOne = new Player("Player1", 'X');
		Player playerTwo = new Player("Player1", 'O');
		Board board = new Board(playerOne, playerTwo);
		Boolean expected = true;
		Boolean actual;

		// Act
		board.replaceCell('1', playerOne);
		actual = board.isAlreadyInserted('1');

		// Arrange
		assertEquals(expected, actual);
	}

	@Test
	public void testIsPlayerXWinPassConditions() {
		// Arrange : check for horizontal strike
		Player playerOne = new Player("Player1", 'X');
		Player playerTwo = new Player("Player1", 'O');
		Board board = new Board(playerOne, playerTwo);
		boolean expected = true;
		boolean actual;
		board.replaceCell('1', playerOne);
		board.replaceCell('2', playerOne);
		board.replaceCell('3', playerOne);

		// Act
		actual = board.isPlayerXwinner(playerOne);

		// Assert
		assertEquals(expected, actual);

		// Arrange: check for vertical strike
		// Refresh board
		board = new Board(playerOne, playerTwo);
		actual = false;
		board.replaceCell('1', playerOne);
		board.replaceCell('4', playerOne);
		board.replaceCell('5', playerOne);

		// Act
		actual = board.isPlayerXwinner(playerOne);

		// Arrange : check for left to right diagonal strike
		// refresh board
		board = new Board(playerOne, playerTwo);
		actual = false;
		board.replaceCell('1', playerTwo);
		board.replaceCell('5', playerTwo);
		board.replaceCell('9', playerTwo);

		// Act
		actual = board.isPlayerXwinner(playerTwo);

		// Assert
		assertEquals(expected, actual);

		// Arrange : check for right to left diagonal
		// refresh board
		board = new Board(playerOne, playerTwo);
		actual = false;
		board.replaceCell('3', playerTwo);
		board.replaceCell('5', playerTwo);
		board.replaceCell('7', playerTwo);

		// Act
		actual = board.isPlayerXwinner(playerTwo);

		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void testIsPlayerXWinFailConditions() {
		// Arrange : check for horizontal strike
		Player playerOne = new Player("Player1", 'X');
		Player playerTwo = new Player("Player1", 'O');
		Board board = new Board(playerOne, playerTwo);
		boolean expected = false;
		boolean actual = true;
		board.replaceCell('1', playerOne);
		board.replaceCell('2', playerOne);

		// Act
		actual = board.isPlayerXwinner(playerOne);

		// Assert
		assertEquals(expected, actual);

		// Arrange: check for vertical strike
		// Refresh board
		board = new Board(playerOne, playerTwo);
		actual = true;
		board.replaceCell('1', playerOne);
		board.replaceCell('4', playerOne);

		// Act
		actual = board.isPlayerXwinner(playerOne);

		// Arrange : check for left to right diagonal strike
		// refresh board
		board = new Board(playerOne, playerTwo);
		actual = true;
		board.replaceCell('1', playerTwo);
		board.replaceCell('5', playerTwo);

		// Act
		actual = board.isPlayerXwinner(playerTwo);

		// Assert
		assertEquals(expected, actual);

		// Arrange : check for right to left diagonal
		// refresh board
		board = new Board(playerOne, playerTwo);
		actual = true;
		board.replaceCell('3', playerTwo);
		board.replaceCell('5', playerTwo);

		// Act
		actual = board.isPlayerXwinner(playerTwo);

		// Assert
		assertEquals(expected, actual);

		// Arrange : when other player has won
		board = new Board(playerOne, playerTwo);
		actual = true;
		boolean expectedOtherPlayersWin = true;
		boolean otherPlayer = false;
		board.replaceCell('3', playerTwo);
		board.replaceCell('5', playerTwo);
		board.replaceCell('7', playerTwo);

		// Act
		actual = board.isPlayerXwinner(playerOne);
		otherPlayer = board.isPlayerXwinner(playerTwo);

		// Assert
		assertEquals(expected, actual);
		assertEquals(expectedOtherPlayersWin, otherPlayer);
	}

	@Test
	public void testIsGameDraw() {
		// Arrange
		Player playerOne = new Player("Player1", 'X');
		Player playerTwo = new Player("Player1", 'O');
		Board board = new Board(playerOne, playerTwo);
		boolean expectedWhenNotDraw = false;
		boolean expectedWhenDraw = true;
		boolean actual = true;

		// Act : when not draw
		board.replaceCell('1', playerOne);
		board.replaceCell('2', playerOne);
		board.replaceCell('3', playerTwo);
		board.replaceCell('4', playerTwo);
		board.replaceCell('5', playerTwo);
		actual = board.isGameDraw();

		// assert : when not draw
		assertEquals(expectedWhenNotDraw, actual);

		// Act: when draw
		board.replaceCell('6', playerOne);
		board.replaceCell('7', playerOne);
		board.replaceCell('8', playerTwo);
		board.replaceCell('9', playerOne);
		actual = board.isGameDraw();

		// Assert
		assertEquals(expectedWhenDraw, actual);
	}
}
