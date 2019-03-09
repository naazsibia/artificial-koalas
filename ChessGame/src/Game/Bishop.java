package Game;
/**
 * This class allows making, selecting, moving, and killing a Bishop. 
 * @author zuqing li
 *
 */

public class Bishop extends Piece{
	/**
	 * Create a Bishop given position and color.
	 * @param position The Bishop's position.
	 * @param color The Bishop's color
	 */
	public Bishop (Position position, String color) {
		super(position.getX(),position.getY(), color);
		
	}
	
	@Override
	public String toString() {
		return "Bishop";
	}
}
