import javafx.event.ActionEvent;

/**
 * This class handles the event in which a button with a King is clicked. It attacks the King
 * if a Piece was clicked earlier, or 
 * @author naazsibia
 *
 */
public class KingHandler extends PieceHandler {
	/**
	 * This makes a new KingHandler with the given board.
	 * @param board
	 */
	public KingHandler(Board board)  {
		super(board);
	}
	/**
	 * Handles the event in which a King is clicked by 
	 * selecting potential spots king can move to or 
	 * attacking the king.
	 */
	@Override 
	public void handle(ActionEvent event) {
		// got attacked -- i.e. wasn't the first piece selected
		if(getBoard().getSelectedPiece() != null) {
			super.handle(event);
			return;
		}

		PieceButton[][] boardModel = getBoardModel();
		Board board = getBoard();
		PieceButton button = (PieceButton) event.getSource();
		board.setSelectedPiece(button);
		Piece piece = button.getPiece();
		int row = button.getPosition().getX();
		int col = button.getPosition().getY();
		button.select();  // select button itself
		PieceButton buttonToSelect;
		Piece pieceToAttack;
		// select unit below
		if(row < 7) {
			buttonToSelect = boardModel[row + 1][col];
			pieceToAttack = buttonToSelect.getPiece();
			if(pieceToAttack == null || pieceToAttack.getColor() != piece.getColor())
				buttonToSelect.select();
		}

		// select unit above
		if(row > 0) {
			buttonToSelect = boardModel[row - 1][col];
			pieceToAttack = buttonToSelect.getPiece();
			if(pieceToAttack == null || pieceToAttack.getColor() != piece.getColor())
				buttonToSelect.select();
		}
		// select unit on the right
		// select unit on the left
		if(col < 7) {
			buttonToSelect = boardModel[row][col + 1];
			pieceToAttack = buttonToSelect.getPiece();
			if(pieceToAttack == null || pieceToAttack.getColor() != piece.getColor())
				buttonToSelect.select();
		}
		
		// select unit on the left
		if(col > 0) {
			buttonToSelect = boardModel[row][col - 1];
			pieceToAttack = buttonToSelect.getPiece();
			if(pieceToAttack == null || pieceToAttack.getColor() != piece.getColor())
				buttonToSelect.select();
		}
		
		// up-left
		if(row > 0 && col > 0) {
			buttonToSelect = boardModel[row - 1][col - 1];
			pieceToAttack = buttonToSelect.getPiece();
			if(pieceToAttack == null || pieceToAttack.getColor() != piece.getColor())
				buttonToSelect.select();
		}
		
		// up-right
		if(row > 0 && col < 7) {
			buttonToSelect = boardModel[row - 1][col + 1];
			pieceToAttack = buttonToSelect.getPiece();
			if(pieceToAttack == null || pieceToAttack.getColor() != piece.getColor())
				buttonToSelect.select();
		}
		
		// down-left
		if(row < 7 && col > 0) {
			buttonToSelect = boardModel[row + 1][col - 1];
			pieceToAttack = buttonToSelect.getPiece();
			if(pieceToAttack == null || pieceToAttack.getColor() != piece.getColor())
				buttonToSelect.select();
		}	
		
		// down-right
		if(row  < 7 && col < 7) {
			buttonToSelect = boardModel[row + 1][col + 1];
			pieceToAttack = buttonToSelect.getPiece();
			if(pieceToAttack == null || pieceToAttack.getColor() != piece.getColor())
				buttonToSelect.select();
		}

	}
}
