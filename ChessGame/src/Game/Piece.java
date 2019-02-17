package Game;
/**
 * This abstract class stores the position and 
 * status of a Piece. 
 * @author sabayar
 *
 */
public abstract class Piece {
	
	private Position p;
	private Boolean onBoard, selected;
	private String color;
	
	public Piece(int x, int y, String color) {
		this.p = new Position(x, y);
		this.onBoard = true; //Every Piece must start on the chess board when created
		this.selected = false;
		this.color = color; //Should only ever be set to black or white
	}
	
	public void removed() {
		this.onBoard = false;
	}
	
	public boolean isRemoved() {
		return this.onBoard;
	}
	
	public Boolean isSelected() {
		return this.selected;
	}
	
	public Position getPosition() {
		return this.p;
	}
	
	public void setPosition(int x, int y) {
		this.p.setX(x);
		this.p.setY(y);
	}
	
	public String getColor() {
		return this.color;
	}
	
	public abstract void selectPiece();
	
	//TODO: Drawing methods?
}
