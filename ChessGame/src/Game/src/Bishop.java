/**
 * This class allows making, selecting, moving, and killing a Bishop. 
 * @author zuqing li
 *
 */

public class Bishop extends Piece{
	
	public Bishop (int x, int y, String color) {
		super(x, y, color);
	}
	
	@Override
	public String toString() {
		if(this.getColor().equals("white")) {
			return "WB";
		}
		return "BB";
	}
}
