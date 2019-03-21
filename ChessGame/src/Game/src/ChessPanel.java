import javafx.scene.layout.GridPane;

public class ChessPanel extends GridPane {
	
	private Board board;
	private View view;
	
	public ChessPanel(Board board, View view) {
		this.board = board;
		this.view = view;
		this.setPrefSize(800, 800);
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
	            this.add(board.getBoardModel()[x][y], y, x, 1, 1);
	        }
		}
	}
	
	public void reset() {
		this.board.reset();
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
	            this.add(board.getBoardModel()[x][y], y, x, 1, 1);
	        }
		}
		view.setCurrentPlayerLabels();
	}
}
