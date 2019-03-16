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
				
	}
}
