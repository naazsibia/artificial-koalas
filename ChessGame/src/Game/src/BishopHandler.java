import javafx.event.ActionEvent;

/**
 * 
 */

/**
 * This class handles the event in which a button with a Bishop is clicked. It attacks the Bishop
 * if a Piece was clicked earlier, or 
 * @author naazsibia
 *
 */
public class BishopHandler extends PieceHandler {

	/**
	 * Makes a new BishopHandler with the given board.
	 * @param board
	 */
	public BishopHandler(Board board) {
		super(board);
	}
	
	/**
	 * Handles the event in which a PieceButton with a bishop is clicked 
	 * @param event 
	 */
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
		King k; // king to watch out for
		if(piece.getColor().equals("black")) k = (King) board.getWhiteKing().getPiece();
		else k = (King)board.getBlackKing().getPiece();
		//diagonal up-left
		int upperRow = row - 1;
		int leftRow = col - 1;
		boolean pieceFound = false;
		while(upperRow > -1 && leftRow > -1 && !pieceFound) {
			Piece pieceHere = boardModel[upperRow][leftRow].getPiece();
			if( pieceHere != null) {
				pieceFound = true; // we stop
				if(pieceHere.getColor() != piece.getColor()) {
					boardModel[upperRow][leftRow].select(); // select opponent
					if(pieceHere.type().equals("King")) k.setSafe(false);
				}
				
			}
			else {
				boardModel[upperRow][leftRow].select(); // select piece
				upperRow--; // check above
				leftRow--;
			}
		}
		
		// diagonal up-right
		upperRow = row - 1;
		int rightRow = col + 1;
		pieceFound = false;
		while(upperRow > -1 && rightRow < 8 && !pieceFound) {
			Piece pieceHere = boardModel[upperRow][rightRow].getPiece();
			if( pieceHere != null) {
				pieceFound = true; // we stop
				if(pieceHere.getColor() != piece.getColor()) {
					boardModel[upperRow][rightRow].select(); // select opponent
					if(pieceHere.type().equals("King")) k.setSafe(false);
				}
				
			}
			else {
				boardModel[upperRow][rightRow].select(); // select piece
				upperRow--; // check above
				rightRow++;
			}
		}
		
		//diagonal down-left
		int downRow = row + 1;
		leftRow = col - 1;
		pieceFound = false;
		while(downRow < 8 && leftRow > -1 && !pieceFound) {
			Piece pieceHere = boardModel[downRow][leftRow].getPiece();
			if( pieceHere != null) {
				pieceFound = true; // we stop
				if(pieceHere.getColor() != piece.getColor()) {
					boardModel[downRow][leftRow].select(); // select opponent
					if(pieceHere.type().equals("King")) k.setSafe(false);
				}
				
			}
			else {
				boardModel[downRow][leftRow].select(); // select piece
				downRow++; // check below
				leftRow--;
			}
		}
		
		
		// diagonal down-right
		downRow = row + 1;
		rightRow = col + 1;
		pieceFound = false;
		while(downRow < 8 && rightRow < 8 && !pieceFound) {
			Piece pieceHere = boardModel[downRow][rightRow].getPiece();
			if( pieceHere != null) {
				pieceFound = true; // we stop
				if(pieceHere.getColor() != piece.getColor()) {
					boardModel[downRow][rightRow].select(); // select opponent
					if(pieceHere.type().equals("King")) k.setSafe(false);
				}
				
			}
			else {
				boardModel[downRow][rightRow].select(); // select piece
				downRow++; // check below
				rightRow++;
			}
		}
		
	}

}
