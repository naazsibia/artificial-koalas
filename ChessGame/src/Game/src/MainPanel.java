import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

import javafx.scene.layout.GridPane;

public class MainPanel extends GridPane implements EventHandler<ActionEvent> {
	
	private View view;

	public MainPanel(View view) {
		this.view = view;
		Button resetButton = new Button("Reset");
		resetButton.setOnAction(this);
		Button quitButton = new Button("Quit");
		quitButton.setOnAction(this);
		VBox vBox = new VBox(resetButton, quitButton);
		vBox.setAlignment(Pos.BASELINE_CENTER);
		vBox.setSpacing(425);
		this.getChildren().add(vBox);
	}
	
	public void handle(ActionEvent event) {
		Button buttonClicked = (Button)event.getSource();
		if(buttonClicked.getText().equals("Reset")){
			view.getChessPanel().reset();
		}
		
		else if(buttonClicked.getText().equals("Quit")) {
			System.exit(0);
		}
		
	}
}
