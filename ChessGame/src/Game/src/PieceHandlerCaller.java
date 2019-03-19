import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class PieceHandlerCaller {
	private Map <String, EventHandler<ActionEvent>> pieceHandlers = new HashMap<String, EventHandler<ActionEvent>>();
	private Board board;
	public PieceHandlerCaller(Board board) {
		this.board = board;
		EventHandler<ActionEvent> pawn = new PawnHandler(board);
		EventHandler<ActionEvent> knight = new KnightHandler(board);
		EventHandler<ActionEvent> rook = new RookHandler(board);
		EventHandler<ActionEvent> bishop = new BishopHandler(board);
		EventHandler<ActionEvent> queen = new QueenHandler(board);
		EventHandler<ActionEvent> king = new KingHandler(board);
		EventHandler<ActionEvent> nullHandler = new NullHandler(board);
		pieceHandlers.put("Pawn", pawn);
		pieceHandlers.put("Knight", knight);
		pieceHandlers.put("Rook", rook);
		pieceHandlers.put("Bishop", bishop);
		pieceHandlers.put("Queen", queen);
		pieceHandlers.put("King", king);
		pieceHandlers.put("null", nullHandler);
	}
	/**
	 * Calls the appropriate handler according to the piecebutton selected when an ActionEvent occurs.
	 * @param event is an ActionEvent.
	 */
	public void handlerCaller(ActionEvent event) {
		PieceButton button = (PieceButton) event.getSource();
		if(button.getPiece() == null) {
			pieceHandlers.get("null").handle(event);
			return;
		}
		pieceHandlers.get(button.getId()).handle(event);;
	}



}
