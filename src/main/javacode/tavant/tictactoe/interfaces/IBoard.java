package main.javacode.tavant.tictactoe.interfaces;

import main.javacode.tavant.tictactoe.implmentation.Player;

public interface IBoard {
	Boolean isAlreadyInserted(Character cellNumber);

	void replaceCell(Character cellNumber, Player player);

	Boolean isPlayerXwinner(Player player);

	Boolean isGameDraw();

}
