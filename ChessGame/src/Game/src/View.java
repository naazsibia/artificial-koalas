
import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
	private Label player1;
	private Label player2;
	
	public View(Board board, Stage stage) {

		this.board = board;
		board.addObserver(this);
		this.mainStage = stage;
		initUI(stage);
	}
	
	public ChessPanel getChessPanel() {
		return this.chessPanel;
	}
	private void initUI(Stage stage) {
		this.chessPanel = new ChessPanel(this.board, this);
		this.mainPanel = new MainPanel(this.board, this);
		player1 = new Label("Player One");
		player1.setAlignment(Pos.CENTER);
		player1.setStyle("-fx-font-weight: bold");
		
		
		player2 = new Label("Player Two");
		player2.setAlignment(Pos.CENTER);
		player2.setStyle("-fx-font-weight: bold");
		player1.setTextFill(Color.RED);
		
		player1.setMinWidth(500);
		player2.setMinWidth(500);
		
		BorderPane root = new BorderPane();
		root.setPrefSize(1000, 1000);
		root.setCenter(this.chessPanel);
		root.setLeft(this.mainPanel);
		root.setTop(player2);
		root.setBottom(player1);
		

		Scene scene = new Scene(root, 570, 550, Color.BLACK);
		stage.setScene(scene);
		stage.setTitle("DefinitelyNotAChessClone");
		stage.show();
	}

	@Override
	public void update(Observable o, Object arg) {
		King k;
		int currentPlayer = board.getCurrentPlayer();
		if(currentPlayer == 0) k = (King)board.getBlackKing().getPiece();
		else k = (King)board.getWhiteKing().getPiece();
		if(k != null && k.isCheckmated()) {
			final Popup popup = new Popup();
	        showStage();
		}
		setCurrentPlayerLabels();
		board.switchTurn(); // switch turn
		
	}
	
	public void setCurrentPlayerLabels() {
		if(board.getCurrentPlayer() == 1) {
			player1.setTextFill(Color.BLACK);
			player2.setTextFill(Color.RED);
		}
		else {
			player1.setTextFill(Color.RED);
			player2.setTextFill(Color.BLACK);
		}
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
