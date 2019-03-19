import javafx.event.ActionEvent;

/**
 * This class handles the event in which a rook is clicked by either attacking the rook 
 * (if a piece was previously clicked) or selecting all the potential pieces that the rook 
 * can move to.
 * @author naazsibia
 *
 */
public class RookHandler extends PieceHandler {

	/**
	 * Makes a new RookHandler with the given board.
	 * @param board
	 */
	public RookHandler(Board board) {
		super(board);
	}
	
	
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
		 
		// select buttons above
		int rowToSelect = row - 1;
		boolean pieceFound = false;
		while(rowToSelect > -1 && !pieceFound) {
			Piece pieceHere = boardModel[rowToSelect][col].getPiece();
			if( pieceHere != null) {
				pieceFound = true; // we stop
				if(pieceHere.getColor() != piece.getColor()) boardModel[rowToSelect][col].select(); // select opponent
				
			}
			else {
				boardModel[rowToSelect][col].select(); // select piece
				rowToSelect --; // check above
			}
		}
		
		// select buttons below
		rowToSelect = row + 1;
		pieceFound = false;
		while(rowToSelect < 8 && !pieceFound) {
			Piece pieceHere = boardModel[rowToSelect][col].getPiece();
			if(boardModel[rowToSelect][col].getPiece() != null) {
				pieceFound = true; // we stop
				if(pieceHere.getColor() != piece.getColor()) boardModel[rowToSelect][col].select();
			}

			else {
				boardModel[rowToSelect][col].select(); // select piece
				rowToSelect ++; // check above
			}
		}
		
		// select buttons to the left
		int colToSelect = col - 1;
		pieceFound = false;
		while(colToSelect > -1 && !pieceFound) {
			Piece pieceHere = boardModel[row][colToSelect].getPiece();
			if(boardModel[row][colToSelect].getPiece() != null) {
				pieceFound = true;
				if(pieceHere.getColor() != piece.getColor()) boardModel[row][colToSelect].select();
			}
			
			else {
				boardModel[row][colToSelect].select(); // select piece
				colToSelect --;
			}
		}
		
		// select buttons to the right
		colToSelect = col + 1;
		pieceFound = false;
		while(colToSelect < 8 && !pieceFound) {
			Piece pieceHere = boardModel[row][colToSelect].getPiece();
			if(boardModel[row][colToSelect].getPiece() != null) {
				pieceFound = true; // 
				if(pieceHere.getColor() != piece.getColor()) boardModel[row][colToSelect].select();
			}
			else {
				boardModel[row][colToSelect].select(); // select piece
				colToSelect ++;
			}
		}
		
		
	}

}
