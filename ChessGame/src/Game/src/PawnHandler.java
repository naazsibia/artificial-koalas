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
	 * This makes a new PawnHandler with the given board
	 * @param board
	 */
	public PawnHandler(Board board) {
		super(board);
	}

	/* Handles the event in which a Pawn is clicked
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
		button.select(); 
		if(piece.getColor().equals("black")) { 
			King k = (King) board.getWhiteKing().getPiece();
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
				if(bottomLeftPiece != null && bottomLeftPiece.getColor().equals("white")) {
					boardModel[row + 1][col - 1].select();
					if(bottomLeftPiece.type().equals("King")) {
						k.setSafe(false);
						System.out.println(k.isSafe());
					}
					
				}
			}
			
			
			// check if you can attack the bottom right 
			if(row < 7 && col < 7) {
				Piece bottomRightPiece = boardModel[row + 1][col + 1].getPiece();
				if(bottomRightPiece != null && bottomRightPiece.getColor().equals("white")) {
					boardModel[row + 1][col - 1].select();
					if(bottomRightPiece.type().equals("King")) {
						k.setSafe(false);
					}
				}
			}
		}
		else { // select button above if no piece on there already
			King k = (King)board.getBlackKing().getPiece();
			if(row > 0 && boardModel[row - 1][col].getPiece() == null) {
				boardModel[row - 1][col].select();
			}
			if(row == 6 && boardModel[row - 2][col].getPiece() == null) {
				boardModel[row - 2][col].select();
				System.out.println(k.isSafe());
			}
			//check if you can attack top left 
			if(row > 0 && col > 0) {
				Piece topLeftPiece = boardModel[row - 1][col - 1].getPiece();
				if(topLeftPiece != null && topLeftPiece.getColor().equals("black")) {
					boardModel[row - 1][col - 1].select();
					if(topLeftPiece.type().equals("King")) {
						k.setSafe(false);
						System.out.println(k.isSafe());
					}
				}
				
			}
			//check if you can attack top right
			if(row > 0 && col < 7) {
				Piece topRightPiece = boardModel[row - 1][col + 1].getPiece();
				if(topRightPiece != null  && topRightPiece.getColor().equals("black")) {
					if(topRightPiece.type().equals("King")) {
						k.setSafe(false);
						System.out.println(k.isSafe());
					}
					boardModel[row - 1][col + 1].select();
				}
			}
		}
	
	}

}
