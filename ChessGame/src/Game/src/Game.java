package Game.src;
/**
 * This class stores the values necessary
 * to any given game of Chess being played.
 * @author sabayar
 *
 */
public class Game {
	
	private int totalTurns, blackPoints, whitePoints;
	private Boolean whiteTurn;

	public Game(boolean whiteTurn) {
		this.totalTurns = 0;
		this.whiteTurn = whiteTurn;
	}
	
	public int getTurns() {
		return this.totalTurns;
	}
	
	public void setTurns(int turns) {
		this.totalTurns = turns;
	}
	
	public int getBlackPoints() {
		return this.blackPoints;
	}
	
	public void setBlackPoints(int blackPoints) {
		this.blackPoints = blackPoints;
	}
	
	public int getWhitePoints() {
		return this.whitePoints;
	}
	
	public void setWhitePoints(int whitePoints) {
		this.whitePoints = whitePoints;
	}
	
	public boolean isWhiteTurn() {
		return this.whiteTurn;
	}
	
	public void switchTurns() {
		this.whiteTurn = !this.whiteTurn;
	}
	
	//TODO: Make methods/calls pertaining to Board class to change board (Board class is unfinished at time of writing)
}
