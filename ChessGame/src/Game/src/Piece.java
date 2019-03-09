/**
 * This abstract class stores the position and 
 * status of a Piece. 
 * @author sabayar
 *
 */
public abstract class Piece {
	
	private Position p;
	private String color;
	
	public Piece(int x, int y, String color) {
		this.p = new Position(x, y);
		this.color = color; //Should only ever be set to black or white
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
	
	public abstract String toString();
}
