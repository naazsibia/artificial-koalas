/**
 * 
 * @author naazsibia
 *
 */
public class Queen extends Piece {

	public Queen(int x, int y, String color) {
		super(x, y, color);
	}

	@Override
	public String toString() {
		if(this.getColor().equals("white")) {
			return "WQ";
		}
		return "BQ";
	}

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "Queen";
	}

}
