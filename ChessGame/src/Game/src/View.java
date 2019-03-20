
import java.util.Observable;
import java.util.Observer;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View implements Observer {
	
	private Board board;
	private ChessPanel chessPanel;
	private MainPanel mainPanel;
	
	public View(Board board, Stage stage) {

		this.board = board;
		board.addObserver(this);
		initUI(stage);
	}
	
	private void initUI(Stage stage) {
		this.chessPanel = new ChessPanel(this.board, this);
		this.mainPanel = new MainPanel(this);

		BorderPane root = new BorderPane();
		root.setPrefSize(1000, 1000);
		root.setCenter(this.chessPanel);
		root.setLeft(this.mainPanel);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("DefinitelyNotAChessClone");
		stage.show();
	}

	@Override
	public void update(Observable o, Object arg) {
		King k;
		if(board.getCurrentPlayer() == 0) k = (King)board.getBlackKing().getPiece();
		else k = (King)board.getWhiteKing().getPiece();
		if(k.isCheckmated()) {
			System.out.println("Game over");
		}
		board.switchTurn(); // switch turn
		
		
	}
}
