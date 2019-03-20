
import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class View implements Observer, EventHandler<ActionEvent> {
	
	private Board board;
	private ChessPanel chessPanel;
	private MainPanel mainPanel;
	private Stage mainStage;
	private Stage popup;
	public View(Board board, Stage stage) {

		this.board = board;
		board.addObserver(this);
		this.mainStage = stage;
		initUI(stage);
	}
	
	private void initUI(Stage stage) {
		this.chessPanel = new ChessPanel(this.board, this);
		this.mainPanel = new MainPanel(this);

		BorderPane root = new BorderPane();
		root.setPrefSize(1000, 1000);
		//root.setPadding(new Insets(150, 0, 100, 100));
		root.setCenter(this.chessPanel);
		root.setLeft(this.mainPanel);

		Scene scene = new Scene(root, 500, 500, Color.BLACK);
		stage.setScene(scene);
		stage.setTitle("DefinitelyNotAChessClone");
		stage.show();
	}

	@Override
	public void update(Observable o, Object arg) {
		King k;
		if(board.getCurrentPlayer() == 0) k = (King)board.getBlackKing().getPiece();
		else k = (King)board.getWhiteKing().getPiece();
		if(k != null && k.isCheckmated()) {
			//System.out.println("Game over");
			final Popup popup = new Popup();
			//stage.close();
	        showStage();
		}
		board.switchTurn(); // switch turn
		
		
	}
	
	public void showStage(){
		Stage newStage = new Stage();
		VBox comp = new VBox();
		Label nameField = new Label("Game Over");
		Button playAgain = new Button("Play Again");
		playAgain.setOnAction(this);
		Button close = new Button("Close");
		close.setOnAction(this);
		playAgain.setMinSize(100, 20);
		close.setMinSize(100, 20);
		comp.getChildren().add(nameField);
		comp.getChildren().add(playAgain);
		comp.getChildren().add(close);
		

		Scene stageScene = new Scene(comp, 100, 100);
		newStage.setScene(stageScene);
		popup = newStage;
		newStage.show();
	}

	@Override // this will just happen when Play Again is clicked 
	public void handle(ActionEvent event) {
		Button buttonClicked = (Button)event.getSource();
		if(buttonClicked.getText().equals("Play Again")){
			popup.close();
			this.chessPanel.reset();
		}
		
		else if(buttonClicked.getText().equals("Close")) {
			popup.close();
			mainStage.close();
		}
		
	}
	
	
}
