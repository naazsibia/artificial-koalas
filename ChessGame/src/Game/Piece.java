package Game;
/**
 * This abstract class stores the position and 
 * status of a Piece. 
 * @author sabayar
 *
 */
public abstract class Piece {
	
	private Position p;
	private Boolean onBoard;
	
	public Piece(int x, int y) {
		this.p = new Position(x, y);
		this.onBoard = true; //Every Piece must start on the chess board when created
	}
	
	public void removed() {
		this.onBoard = false;
	}
	
	public boolean isRemoved() {
		return this.onBoard;
	}
	
	public Position getPosition() {
		return this.p;
	}
	
	public void setPosition(int x, int y) {
		this.p.setX(x);
		this.p.setY(y);
	}
	
	public abstract void selectPiece();
	
	//TODO: Drawing methods?
}
