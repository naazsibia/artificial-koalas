import javafx.event.ActionEvent;

/**
 * This class handles the event in which a PieceButton with a knight is clicked. In case the 
 * knight is the first piece clicked, it highlights all the possible positions the knight 
 * can move to. Otherwise, the knight is attacked and killed.
 * @author naazsibia
 *
 */
public class KnightHandler extends PieceHandler {
	/**
	 * Makes a new KnightHandler with the given Board. 
	 * @param board
	 */
	public KnightHandler(Board board) {
		super(board);
	}
	/**
	 * Handles the event in which a PieceButton with a knight is clicked 
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
		if(!button.isCanSelect()) {
			return;
		}
		board.setSelectedPiece(button);
		Piece piece = button.getPiece();
		int row = button.getPosition().getX();
		int col = button.getPosition().getY();
		button.select();  // select button itself
		King k; // king to watch out for
		if(piece.getColor().equals("black")) k = (King) board.getWhiteKing().getPiece();
		else k = (King) board.getWhiteKing().getPiece();
		// 2 up
		if(row > 1) {
			// 1 left
			if(col > 0) {
				Piece pieceAtButton = boardModel[row - 2][col - 1].getPiece();
				if(pieceAtButton == null || pieceAtButton.getColor() != piece.getColor()) {
					boardModel[row - 2][col - 1].select();
					if(pieceAtButton != null && pieceAtButton.type().equals("King")) {
						k.setSafe(false);
					}
				}
			}
			
			// 1 right
			if(col < 7) {
				Piece pieceAtButton = boardModel[row - 2][col + 1].getPiece();
				if(pieceAtButton == null || pieceAtButton.getColor() != piece.getColor()) {
					boardModel[row - 2][col + 1].select();
					if(pieceAtButton != null && pieceAtButton.type().equals("King")) {
						k.setSafe(false);
					}
				}
			}
		}
		// 2 down
		if(row < 6) {
			// 1 left
			if(col > 0) {
				Piece pieceAtButton = boardModel[row + 2][col - 1].getPiece();
				if(pieceAtButton == null || pieceAtButton.getColor() != piece.getColor()) {
					boardModel[row + 2][col - 1].select();
					if(pieceAtButton != null && pieceAtButton.type().equals("King")) {
						k.setSafe(false);
					}
				}
			}
			
			// 1 right
			if(col < 7) {
				Piece pieceAtButton = boardModel[row + 2][col + 1].getPiece();
				if(pieceAtButton == null || pieceAtButton.getColor() != piece.getColor()) {
					boardModel[row + 2][col + 1].select();
					if(pieceAtButton != null && pieceAtButton.type().equals("King")) {
						k.setSafe(false);
					}
				}
			}	
		}
		
		// 1 up
		if(row > 0) {
			// 2 left
			if(col > 1) {
				Piece pieceAtButton = boardModel[row - 1][col - 2].getPiece();
				if(pieceAtButton == null || pieceAtButton.getColor() != piece.getColor()) {
					boardModel[row - 1][col - 2].select();
					if(pieceAtButton != null && pieceAtButton.type().equals("King")) {
						k.setSafe(false);
					}
				}
			}
			
			// 2 right
			if(col < 6) {
				Piece pieceAtButton = boardModel[row - 1][col + 2].getPiece();
				if(pieceAtButton == null || pieceAtButton.getColor() != piece.getColor()) {
					boardModel[row - 1][col + 2].select();
					if(pieceAtButton != null && pieceAtButton.type().equals("King")) {
						k.setSafe(false);
					}
				}
			}
		}
		
		// 1 down
		if(row < 6) {
			// 2 left
			if(col > 1) {
				Piece pieceAtButton = boardModel[row + 1][col - 2].getPiece();
				if(pieceAtButton == null || pieceAtButton.getColor() != piece.getColor()) {
					boardModel[row + 1][col - 2].select();
					if(pieceAtButton != null && pieceAtButton.type().equals("King")) {
						k.setSafe(false);
					}
				}
			}
			
			// 2 right
			if(col < 6) {
				Piece pieceAtButton = boardModel[row + 1][col + 2].getPiece();
				if(pieceAtButton == null || pieceAtButton.getColor() != piece.getColor()) {
					boardModel[row + 1][col + 2].select();
					if(pieceAtButton != null && pieceAtButton.type().equals("King")) {
						k.setSafe(false);
					}
				}
			}
		}
		
	}
}
