/**
 * This class is a child of the Piece class, and
 * contains the methods of a Pawn
 * @author Jonathan Martin
 *
 */

public class Pawn extends Piece {
	
	public Pawn(int x, int y, String color) {
		super(x, y, color);
	}

	@Override
	public String toString() {
		if(this.getColor() == "white") {
			return "WP";
		}
		return "BP";
	}

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "Pawn";
	}
	
}
