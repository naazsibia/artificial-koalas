/**
 * This class is a child of the Piece class, and
 * contains the methods of a Knight piece in Chess.
 * @author sabayar
 *
 */

public class Knight extends Piece {

	public Knight(int x, int y, String color) {
		super(x, y, color);
	}
	
	@Override
	public String toString() {
		if(this.getColor().equals("white")) {
			return "WKN";
		}
		return "BKN";
	}

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "Knight";
	}
	
}
