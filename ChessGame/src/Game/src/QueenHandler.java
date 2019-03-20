import javafx.event.ActionEvent;

/**
 * This class handles the event in which a button with a Queen is clicked.
 * In case this button wasn't the first button that a user clicked, then the Queen is attacked. 
 * If this is the first button that the user clicks then the button selects itself and the next 
 * potential buttons it can move to. A pawn can move and attack diagonally, vertically and 
 * horizontally. 
 * @author naazsibia
 *
 */
public class QueenHandler extends PieceHandler{
	/**
	 * This makes a new Queen handler with the given Board.
	 * @param board
	 */
	public QueenHandler(Board board) {
		super(board);
	}
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
		if(!button.isCanSelect()) {
			return;
		}
		button.select();  // select button itself
		King k; // king to watch out for
		if(piece.getColor().equals("black")) k = (King)board.getWhiteKing().getPiece();
		else k =  (King)board.getBlackKing().getPiece();
		// select buttons vertically above
		int rowToSelect = row - 1;
		boolean pieceFound = false;
		while(rowToSelect > -1 && !pieceFound) {
			Piece pieceHere = boardModel[rowToSelect][col].getPiece();
			if( pieceHere != null) {
				pieceFound = true; // we stop
				if(pieceHere.getColor() != piece.getColor()) {
					 boardModel[rowToSelect][col].select(); // select opponent
					 if(pieceHere.type().equals("King")) k.setSafe(false);
				}

			}
			else {
				boardModel[rowToSelect][col].select(); // select piece
				rowToSelect --; // check above
			}
		}

		// select buttons vertically below
		rowToSelect = row + 1;
		pieceFound = false;
		while(rowToSelect < 8 && !pieceFound) {
			Piece pieceHere = boardModel[rowToSelect][col].getPiece();
			if(boardModel[rowToSelect][col].getPiece() != null) {
				pieceFound = true; // we stop
				if(pieceHere.getColor() != piece.getColor()) {
					boardModel[rowToSelect][col].select();
					if(pieceHere.type().equals("King")) k.setSafe(false);
				}
			}

			else {
				boardModel[rowToSelect][col].select(); // select piece
				rowToSelect ++; // check above
			}
		}

		// select buttons horizontally on the left
		int colToSelect = col - 1;
		pieceFound = false;
		while(colToSelect > -1 && !pieceFound) {
			Piece pieceHere = boardModel[row][colToSelect].getPiece();
			if(boardModel[row][colToSelect].getPiece() != null) {
				pieceFound = true;
				if(pieceHere.getColor() != piece.getColor()) {
					boardModel[row][colToSelect].select();
					if(pieceHere.type().equals("King")) k.setSafe(false);
				}
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
				if(pieceHere.getColor() != piece.getColor()) {
					boardModel[row][colToSelect].select();
					if(pieceHere.type().equals("King")) k.setSafe(false);
				}
			}
			else {
				boardModel[row][colToSelect].select(); // select piece
				colToSelect ++;
			}
		}
		//diagonal up-left
		int upperRow = row - 1;
		int leftRow = col - 1;
		pieceFound = false;
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
