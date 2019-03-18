import javafx.application.Application;
import javafx.stage.Stage;

public class DefinitelyNotAChessClone extends Application {
	
	Board board; // Model
	View view; // Also includes Controller component alongside namesake
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.board = new Board();
		this.view = new View(board, stage);
	}
	
}
