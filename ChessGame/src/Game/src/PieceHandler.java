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
	@Override
	public void handle(ActionEvent event) {
		Board board = getBoard();
		PieceButton button = (PieceButton) event.getSource();
		//in case this isn't the first button selected -- the pawn has been attacked
		PieceButton selectedButton = board.getSelectedPiece();
		Piece selectedPiece = selectedButton.getPiece();
		
		if (selectedButton == button) {
			button.select(); // deselect
			return;
		}
		
		if(selectedPiece != null) {
			button.select(); // will deselect it 
			button.setPiece(selectedPiece); 
			selectedButton.select(); // will deselect it
			selectedButton.setPiece(null); // that piece moved here
			return;
		}
	}

	// get PieceHandler to check if King's safe as well 
	
	
}
