/**
 * This class allows making, selecting, moving, and killing a Bishop. 
 * @author zuqing li
 *
 */

package Game;

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
	public void selectPiece() {
		this.setSelected(true);
		int currentX = this.getPosition().getX();
		int currentY = this.getPosition().getY();
		int index = 0;
		Position[] validMoves = new Position[] {};
		while(currentX != 0 && currentY != 0) {
			validMoves[index] = new Position(currentX - 1, currentY - 1);
			index++;
		}
		while(currentX != 7 && currentY != 7) {
			validMoves[index] = new Position(currentX + 1, currentY + 1);
			index++;
		}
		while(currentX != 0 && currentY != 7) {
			validMoves[index] = new Position(currentX - 1, currentY + 1);
			index++;
		}
		while(currentX != 7 && currentY != 0) {
			validMoves[index] = new Position(currentX + 1, currentY - 1);
			index++;
		}
		
	}

	
}
