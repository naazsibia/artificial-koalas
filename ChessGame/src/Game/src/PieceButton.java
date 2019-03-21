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
		this.color = color;
		if(piece == null) setId("null");
		else setId(piece.type());
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
			return;
		}
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
			setId(piece.type());
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
		setCanSelect(selected); 
	}
	/** Select current button if unselected, or else deselect it by changing image.
	 * @return whether true iff button is selected
	 */
	public boolean select() {
		if(piece == null) {
			if(isSelected()) {
				setSelected(false);
				changeImage();
				return false;
			}
			else {
				setSelected(true);
				changeImage();
				return false;
			}
		}
		// piece is not null
		if(isSelected()) {
			setSelected(false);
			changeImage();
			return false;
		}
		setSelected(true);
		changeImage();
		return true;
	}
	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * Change the image of this button according to whether it is selected or unselected.
	 */
	public void changeImage() {
		if(isSelected()) {
			if(piece != null) {
				Image image = new Image(this.getClass().getResource("Icons/" + piece.toString() + "S" + this.toString() + ".jpg").toString());
				ImageView iv = new ImageView(image);
				this.setGraphic(iv);
				setMinWidth(image.getWidth());
				setMaxWidth(image.getWidth());
				setMinHeight(image.getHeight());
				setMaxHeight(image.getHeight());
				return;
			}
			Image image;
			if(color == 0) image = new Image(this.getClass().getResource("Icons/blue.jpg").toString());
			else image = new Image(this.getClass().getResource("Icons/maroon.jpg").toString());
			ImageView iv = new ImageView(image);
			this.setGraphic(iv);
			setMinWidth(image.getWidth());
			setMaxWidth(image.getWidth());
			setMinHeight(image.getHeight());
			setMaxHeight(image.getHeight());
			return;
		}
		Image image;
		if(piece != null) {
			if (color == 0) {
				image = new Image(this.getClass().getResource("Icons/" + piece.toString() + "UW.jpg").toString());
			}else {
				image = new Image(this.getClass().getResource("Icons/" + piece.toString() + "UB.jpg").toString());
			}
		} 
		else {
			if(color == 0) {
				image = new Image(this.getClass().getResource("Icons/white.jpg").toString());
			} else {
				image = new Image(this.getClass().getResource("Icons/black.jpg").toString());
			}
		}
		ImageView iv = new ImageView(image);
		setMinWidth(image.getWidth());
		setMaxWidth(image.getWidth());
		setMinHeight(image.getHeight());
		setMaxHeight(image.getHeight());
		this.setGraphic(iv);
		return;
	}
	/**
	 * Returns the string representation of this button
	 */
	public String toString() {
		if(color == 0) return "W";
		return "B";
	}
}
