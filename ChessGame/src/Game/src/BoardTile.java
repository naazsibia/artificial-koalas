
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseButton;

public class BoardTile extends StackPane {

        public BoardTile(boolean isBlack) {
            Rectangle border = new Rectangle(100, 100);
            if (isBlack == true) {
            	border.setFill(Color.BLACK);
            } else {
            	border.setFill(null);
            }
            border.setStroke(Color.BLACK);
            getChildren().addAll(border);
            
            setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                	//TODO: Add selection code here
                }
                else if (event.getButton() == MouseButton.SECONDARY) {
                	//TODO: Add de-selection code here
                }
            });
        }
    }
