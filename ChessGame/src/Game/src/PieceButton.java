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
	private int color;
	/**
	 * Makes a new PieceButton at a given position
	 */
	public PieceButton(Position position, boolean canSelect, int color) {
		this(position, canSelect, null, color);
	}
	
	/**
	 * Makes a new PieceButton at a given position
	 */
	public PieceButton(Position position, boolean canSelect, Piece piece, int color) {
		this.position = position;
		this.piece = piece; 
		this.canSelect = canSelect;
		if(piece == null) setId("null");
		else setId(piece.toString());
		changeImage();
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
		if(piece == null) {
			setId("null");
		}
		else {
			setId(piece.toString());
		}
		changeImage();
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
			if(piece == null) {
				setDisable(true);
				canSelect = false;
			}
			return false;
		}
		changeImage();
		setSelected(true);
		setDisable(false);
		canSelect = true;
		return true;
	}
	/**
	 * Change the image of this button according to whether it is selected or unselected.
	 */
	public void changeImage() {
		if(isSelected()) {
			if(piece != null) {
				Image image = new Image(this.getClass().getResource(piece.toString() + "S" + this.toString() + ".jpg").toString());
				ImageView iv = new ImageView(image);
				this.setGraphic(iv);
				setMinWidth(image.getWidth());
				setMaxWidth(image.getWidth());
				setMinHeight(image.getHeight());
				setMaxHeight(image.getHeight());
				return;
			}
			Image image;
			if(color == 0) image = new Image(this.getClass().getResource("blue.jpg").toString());
			else image = new Image(this.getClass().getResource("maroon.jpg").toString());
			ImageView iv = new ImageView(image);
			this.setGraphic(iv);
			setMinWidth(image.getWidth());
			setMaxWidth(image.getWidth());
			setMinHeight(image.getHeight());
			setMaxHeight(image.getHeight());
			return;
		}
		if(piece != null) {
			Image image = new Image(this.getClass().getResource(piece.toString() + "U" + this.toString() + ".jpg").toString());
			ImageView iv = new ImageView(image);
			this.setGraphic(iv);
			setMinWidth(image.getWidth());
			setMaxWidth(image.getWidth());
			setMinHeight(image.getHeight());
			setMaxHeight(image.getHeight());
			return;
		}
		Image image;
		if(color == 0) image = new Image(this.getClass().getResource("white.jpg").toString());
		else image = new Image(this.getClass().getResource("black.jpg").toString());
		ImageView iv = new ImageView(image);
		setMinWidth(image.getWidth());
		setMaxWidth(image.getWidth());
		setMinHeight(image.getHeight());
		setMaxHeight(image.getHeight());
		this.setGraphic(iv);
		return;
		
	}

}
