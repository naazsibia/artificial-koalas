package Game.src;
/**
 * This class functions as the game board and stores
 * information on the current board state
 * 
 * @author: Jonathan Martin
 *   
 */
public class Board {
	private PieceHandler[] boardModel;
	private int currentPlayer;
	
	public Board() {
		this.boardModel = new PieceHandler[32];
		//TODO: Add each piece to the board
		this.currentPlayer = 1;
	}
	
	public void switchTurn() {
		if(this.currentPlayer == 0) {
			this.currentPlayer = 1;
		}else {
			this.currentPlayer = 0;
		}
	}
	
	public PieceHandler[] getBoardModel() {
		return this.boardModel;
	}
	
	public int getCurrentPlayer() {
		return this.currentPlayer;
	}
}
