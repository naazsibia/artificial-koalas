import java.awt.Button;
import javafx.scene.layout.StackPane;

public class ChessPanel extends StackPane {
	
	private Board board;
	private View view;
	private BoardTile[][] b = new BoardTile[8][8];//Placeholder, does the same thing as BoardModel in Board.java
	
	public ChessPanel(Board board, View view) {
		this.board = board;
		this.view = view;
		this.setPrefSize(800, 800);
		boolean isBlack = true;
		for (int i = 0; i < 8; i++) {
			isBlack = !isBlack; //Swaps each tile between black and white
			for (int j = 0; j < 8; j++) {
				BoardTile tile = new BoardTile(isBlack);
	            tile.setTranslateX(j * 100);
	            tile.setTranslateY(i * 100);
	            this.getChildren().add(tile);
	            b[j][i] = tile;
	            isBlack = !isBlack;
	        }
		}
	}
}
