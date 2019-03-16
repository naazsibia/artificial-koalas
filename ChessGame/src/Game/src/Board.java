/**
 * This class functions as the game board and stores
 * information on the current board state
 * 
 * @author: Jonathan Martin
 *   
 */
public class Board {
	private PieceButton[][] boardModel;
	private int currentPlayer;
	private PieceButton selectedPiece;
	
	public Board() {
		this.boardModel = new PieceButton[8][8];
		// Create 64 PieceButtons, one for each position on the board 
		for (int x = 0; x < 8; x = x+1) {
			PieceButton[] column = new PieceButton[8];
			for (int y = 0; y < 8; y = y+1) {
				column[y] = new PieceButton(new Position(x, y), false, (x + y) % 2 );
			}
			this.boardModel[x] = column;
		}
		
		this.currentPlayer = 1;
		this.selectedPiece = null;
	}
	
	public void switchTurn() {
		if(this.currentPlayer == 0) {
			this.currentPlayer = 1;
		}else {
			this.currentPlayer = 0;
		}
	}
	
	public PieceButton[][] getBoardModel() {
		return this.boardModel;
	}
	
	public int getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	public PieceButton getSelectedPiece() {
		return this.selectedPiece;
	}
	
	public void setSelectedPiece(PieceButton pb) {
		this.selectedPiece = pb;
	}
}
