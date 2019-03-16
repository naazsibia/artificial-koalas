/**
 * 
 */

/**
 * This class allows making, selecting, moving, and killing a King. It will also help warn users in
 * the game if a king is about to be checkmated. 
 * @author naazsibia
 *
 */
public class King extends Piece{
	private boolean safe; // will keep track of whether king is safe or about to be checkmated
	private boolean checkmated; // will keep track of whether king has been checkmated
	/**
	 * Makes a new King with the given Position and color.
	 */
	public King(int x, int y, String color) {
		super(x, y, color);
		safe = true;
		checkmated = false;
	}

	/**
	 * Returns true iff King is safe.
	 * @return safe: a boolean that represents whether the king is about to be checkmated
	 */
	public boolean isSafe() {
		return safe;
	}
	/**
	 * Returns true iff King has been checkmated.
	 * @return checkmate: a boolean that represents whether the king has been checkmated
	 */
	public boolean isCheckmated() {
		return checkmated;
	}
	
	/**
	 * Changes safety of King. If King was safe earlier, then safety is changed to false else 
	 * it is changed to true.
	 */
	public void changeSafety() {
		if(safe){
			safe = false;
		}
		else{
			safe = true;
		}
	}
	
	/**
	 * Changes whether King has been checkmated. If the king was not checkmated earlier, this makes 
	 * the king checkmated.
	 */
	public void changeCheckmated() {
		if(!checkmated) {
			checkmated = true;
		}
	}

	@Override
	public String toString() {
		if(this.getColor().equals("white")) {
			return "WK";
		}
		return "BK";
	}	
}
