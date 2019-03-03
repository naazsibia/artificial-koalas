import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 */

/** This class enables clicking piece buttons, and selecting them. It stores whether the button has been 
 * selected and changes its image accordingly.
 * @author naazsibia
 *
 */
public class PieceButton extends Button{
	private Piece piece;
	private Position position;
	private boolean selected;
	private boolean canSelect;
	/**
	 * Makes a new PieceButton at a given position
	 */
	public PieceButton(Position position, boolean canSelect) {
		this.position = position;
		this.piece = null; //by default
		this.canSelect = canSelect;
		Image image = new Image(this.getClass().getResource(piece.toString() + ".png").toString());
		ImageView iv = new ImageView(image);
		this.setId(piece.toString());
		this.setGraphic(iv);
		setMinWidth(image.getWidth());
		setMaxWidth(image.getWidth());
		setMinHeight(image.getHeight());
		setMaxHeight(image.getHeight());
		
		if(!canSelect) {
			this.setDisable(true);
		}
		else {
			this.setDisable(false);
		}
	}
	/**
	 * @return boolean canSelect which is true iff this button can be selected
	 */
	public boolean isCanSelect() {
		return canSelect;
	}
	/**
	 * @param canSelect the boolean canSelect to set
	 */
	public void setCanSelect(boolean canSelect) {
		this.canSelect = canSelect;
		if(!canSelect) {
			this.setDisable(true);
			return;
		}
		this.setDisable(false);
		
	}
	/**
	 * @return the piece that this button represents
	 */
	public Piece getPiece() {
		return piece;
	}
	/**
	 * @param piece the piece to set
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	/**
	 * @return the position of this button on the chess board
	 */
	public Position getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	/**
	 * @return selected a boolean that is true iff this button has been selected
	 */
	public boolean isSelected() {
		return selected;
	}
	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	/** Select current button if unselected, or else deselect it by changing image.
	 * @return whether true iff button is selected
	 */
	public boolean select() {
		if(isSelected()) {
			Image image = new Image(this.getClass().getResource(piece.toString() + ".png").toString());
			ImageView iv = new ImageView(image);
			this.setGraphic(iv);
			setSelected(false);
			changeImage();
			return false;
		}
		changeImage();
		setSelected(true);
		return true;
	}
	/**
	 * Change the image of this button according to whether it is selected or unselected.
	 */
	public void changeImage() {
		if(isSelected()) {
			if(piece != null) {
				Image image = new Image(this.getClass().getResource(piece.toString() + "Selected.png").toString());
				ImageView iv = new ImageView(image);
				this.setGraphic(iv);
				return;
			}
			Image image = new Image(this.getClass().getResource("blue.png").toString());
			ImageView iv = new ImageView(image);
			this.setGraphic(iv);
			return;
		}
		if(piece != null) {
			Image image = new Image(this.getClass().getResource(piece.toString() + ".png").toString());
			ImageView iv = new ImageView(image);
			this.setGraphic(iv);
			return;
		}
		Image image = new Image(this.getClass().getResource("white.png").toString());
		ImageView iv = new ImageView(image);
		this.setGraphic(iv);
		return;
		
	}

}
