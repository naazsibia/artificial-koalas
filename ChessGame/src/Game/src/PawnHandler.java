import javafx.event.ActionEvent;
/**
 * This class handles the event in which a button with a Pawn is clicked.
 * In case this button wasn't the first button that a user clicked, then the Pawn is attacked. 
 * If this is the first button that the user clicks then the button selects itself and the next 
 * potential buttons it can move to. A pawn can move one block forward (or 2 if it's the first move)
 * if there are no pieces there. To attack, the pawn can move one block diagonally. 
 * @author naazsibia
 *
 */
public class PawnHandler extends PieceHandler {

	/**
	 * @param board
	 */
	public PawnHandler(Board board) {
		super(board);
	}

	/* (non-Javadoc)
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */

	public void handle(ActionEvent event) {
		if(getBoard().getSelectedPiece() != null) {
			super.handle(event);
			return;
		}
		// this is the first piece button that's been selected 
		PieceButton[][] boardModel = getBoardModel();
		Board board = getBoard();
		PieceButton button = (PieceButton) event.getSource();
		board.setSelectedPiece(button);
		Piece piece = button.getPiece();
		int row = button.getPosition().getX();
		int col = button.getPosition().getY();
		boolean isBlack = piece.getColor().equals("Black");
		button.select(); 
		if(isBlack) { 
			// select button below if no piece on there already
			if(row < 7 && boardModel[row + 1][col].getPiece() == null) {
				boardModel[row + 1][col].select();
			}
			if(row == 1 && boardModel[row + 2][col].getPiece() == null) { // first move
				boardModel[row + 2][col].select();
			}
			// check if you can attack the bottom left
			if(row < 7 && col > 0) {
				Piece bottomLeftPiece = boardModel[row + 1][col - 1].getPiece();
				if(bottomLeftPiece.getColor().equals("white")) boardModel[row + 1][col].select();
			}
			// check if you can attack the bottom right 
			if(row < 7 && col < 7) {
				Piece bottomRightPiece = boardModel[row + 1][col + 1].getPiece();
				if(bottomRightPiece.getColor().equals("white")) boardModel[row + 1][col + 1].select();
			}
		}
		else { // select button above if no piece on there already
			if(row > 0 && boardModel[row - 1][col].getPiece() == null) {
				boardModel[row - 1][col].select();
			}
			if(row == 6 && boardModel[row - 2][col].getPiece() == null) {
				boardModel[row - 2][col].select();
			}
			//check if you can attack top left 
			if(row > 0 && col > 0) {
				Piece topLeftPiece = boardModel[row - 1][col - 1].getPiece();
				if(topLeftPiece.getColor().equals("black")) boardModel[row - 1][col - 1].select();
			}
			//check if you can attack top right
			if(row > 0 && col < 7) {
				Piece topRightPiece = boardModel[row - 1][col + 1].getPiece();
				if(topRightPiece.getColor().equals("black")) boardModel[row - 1][col + 1].select();
			}
		}
	
	}

}
