package main.javacode.tavant.tictactoe.implmentation;

public class Player {
	private String playerName;
	private Character playerSymbol;

	public Player(String playerName, Character playerSymbol) {
		this.playerName = playerName;
		this.playerSymbol = playerSymbol;
	}

	public String getPlayerName() {
		return playerName;
	}

	public Character getPlayerSymbol() {
		return playerSymbol;
	}
}
