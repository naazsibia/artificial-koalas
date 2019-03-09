/**
 * This is a child of the Piece class, and
 * contains the methods of a Rook
 * @author Jonathan Martin
 *
 */

public class Rook extends Piece {
	
	public Rook(int x, int y, String color) {
		super(x, y, color);
	}
	
	@Override
	public String toString(){
		return "Rook";
	}
}
