import javafx.event.ActionEvent;
/**
 * This class handles the event in which an empty button (one with no piece) is clicked. This happens 
 * when a player is moving a piece to this button.
 * @author naazsibia
 *
 */
public class NullHandler extends PieceHandler {

	/**
	 * Makes a new NullHandler with the given board
	 * @param board
	 */
	public NullHandler(Board board) {
		super(board);
	}

	
	/**
	 * Changes the piece of this button to the piece that was selected in another piece button
	 */
	@Override
	public void handle(ActionEvent event) {
		super.handle(event); // this can just be handled by the super class 
	}

}
