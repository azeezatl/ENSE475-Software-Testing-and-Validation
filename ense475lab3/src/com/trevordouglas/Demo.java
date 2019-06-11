package com.trevordouglas;

public class Demo {

	public static void main(String[] args) {
		Game game = new Game(5, 3);
		GameStation gameStation = new GameStation(game);
		
		GameCustomer gamer = new GameCustomer();
		gameStation.addObserver(gamer);
		
		gameStation.setGame(game);
		
		gameStation.removeObserver(gamer);
		
	}

}