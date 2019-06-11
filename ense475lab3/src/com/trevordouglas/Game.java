/**
 * 
 */
package com.trevordouglas;

/**
 * @author trevordouglas
 *
 */

public class Game {
	
	private int homeGameID;
	private int visitorGameID;
	private int homeScore;
	private int visitorScore;
	private int currentPeriod;
	
	
	public Game(int homeGameID, int visitorGameID)
	{
		this.homeGameID = homeGameID;
		this.visitorGameID = visitorGameID;
		homeScore = 0;
		visitorScore = 0;
		currentPeriod = 0;
		
	}
	
	public void updateScore(int hScore, int visScore, int currPeriod) {
		this.homeScore = hScore;
		this.visitorScore = visScore;
		this.currentPeriod = currPeriod;
		
	}
	


}

