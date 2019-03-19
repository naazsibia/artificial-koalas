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
		if(this.getColor().equals("white")) {
			return "WR";
		}
		return "BR";
	}

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "Rook";
	}
}
