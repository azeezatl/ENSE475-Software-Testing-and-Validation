/**
 * 
 */
package com.trevordouglas;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author azeezatlawal
 *
 */
public class GameStation implements GameSubject {
	Set<GameObserver> gameObservers;
	GameCenter gameCenter;
	private int homeScore;
	private int visitorScore;
	private int currentPeriod;

	public GameStation(int hScore, int visScore, int currPeriod) {
		gameObservers = new HashSet<GameObserver>();
		this.homeScore = hScore;
		this.visitorScore = visScore;
		this.currentPeriod = currPeriod;
		this.gameCenter = new GameCenter();
	}

	@Override
	public void addObserver(GameObserver gameObserver) {
		gameObservers.add(gameObserver);
	}

	@Override
	public void removeObserver(GameObserver gameObserver) {
		gameObservers.remove(gameObserver);
	}
	
	@Override
	public void doNotify() {
		Iterator<GameObserver> it = gameObservers.iterator();
		while (it.hasNext()) {
			GameObserver gameObserver = it.next();
			gameObserver.doUpdate(this.homeScore, this.visitorScore, this.currentPeriod);
		}
	}
	
	public boolean subscribeToGame(Game game) {
		return this.gameCenter.getTodaysGames().contains(game);
	}

	public void setGameUpdate(Game game, int newHomeScore, int newVisitorScore, int newCurrentPeriod) {
		System.out.println("\nGame station setting newHomeScore to " + newHomeScore + 
				"\nGame station setting newVisitorScore to " + newVisitorScore + 
				"\nGame station setting newCurrentPeriod to " + newCurrentPeriod);
		this.homeScore = newHomeScore;
		this.visitorScore = newVisitorScore;
		this.currentPeriod = newCurrentPeriod;
		
		for (Game temp : this.gameCenter.getTodaysGames()) {
			if (temp == game) {
				temp.updateScore(newHomeScore, newVisitorScore, newCurrentPeriod);
			}
		}
		doNotify();
	}
}
