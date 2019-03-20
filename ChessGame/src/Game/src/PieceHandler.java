import java.util.Observable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

/**
 * This class handles action events for specific piece buttons
 * @author naazsibia
 *
 */
public abstract class PieceHandler implements EventHandler<ActionEvent>{
	private Board board;
	/**
	 * Makes a new PieceHandler
	 * @param board an array of PieceButtons
	 */
	public PieceHandler(Board board) {
		this.setBoard(board);
	}
	/**
	 * @return the board
	 */
	public PieceButton[][] getBoardModel() {
		return getBoard().getBoardModel();
	}
	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}
	/**
	 * @param board the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	/**
	 * Handles the event in which a Piece
	 * is clicked. By default, this handles
	 * the event in which the piece is attacked.
	 */
	@Override
	public void handle(ActionEvent event) {
		Board board = getBoard();
		PieceButton button = (PieceButton) event.getSource();
		//in case this isn't the first button selected -- the piece has been attacked
		PieceButton selectedButton = board.getSelectedPiece();
		if(selectedButton == null) { // nothing was selected previously
			return;
		}
		Piece selectedPiece = selectedButton.getPiece();
		if(selectedPiece == null) { // nothing was selected previously
			return;
		}
		board.setSelectedPiece(null);
		
		// King to watch for
		King k;
		if(board.getCurrentPlayer() == 0) k = (King)board.getBlackKing().getPiece();
		else  k = (King)board.getWhiteKing().getPiece();
		
		
		
		// selected same button again, so deselect
		if (selectedButton == button && button.isSelected()) {
			button.select(); // deselect
			button.setCanSelect(true);
			
		}
		
		// attacked another piece or moved to a blank location
		else if(button.isSelected()){
			if(button.getPiece() != null && button.getPiece().type().equals("King")) {
				k.changeCheckmated(); // king got checkmated
			}
			else {
				button.setPiece(selectedPiece); 
				if(selectedPiece.type().equals("King")) {
					if(selectedPiece.getColor().equals("black")) board.setBlackKing(button);
					else board.setWhiteKing(button);
				}
				selectedButton.select(); // will deselect it
				selectedButton.setPiece(null); // that piece moved here
				button.select(); // will deselect it
			}
			button.setCanSelect(true);
			board.notifyView();	
		}
		PieceButton[][] boardModel = getBoardModel();
		for(int row = 0; row < 8; row ++ ) {
			for(int col = 0; col < 8; col ++) {
				if(boardModel[row][col].isSelected()) {
					boardModel[row][col].select(); // will deselect it
				}
			}
		}	
	}	
}
