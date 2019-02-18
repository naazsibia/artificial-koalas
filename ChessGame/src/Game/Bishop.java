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
	
	
	/**
	 * Select a Bishop by setting selected "true"
	 * @param bishop Class Bishop
	 */
	public void select(Bishop bishop) {
		bishop.selected = true; //A draft because of lacking setSelect function in position
	}
	
	
	/**
	 *  Delete a bishop from the board
	 * @param bishop Class bishop
	 */
	public void kill(Bishop bishop) {
		if(bishop.isRemoved()) {
			bishop.removed();
		}
	}
	/**
	 * Change a bishop's position to a new position if moves diagonally
	 * @param bishop Class Bishop
	 * @param position New position want to move
	 */
	public void LegalMove(Bishop bishop, Position position) {
		if(bishop.isSelected() && !bishop.isRemoved()) {
			if( Math.abs(bishop.getPosition().getX() - position.getX()) == 
				Math.abs(bishop.getPosition().getY() - position.getY())) {
				bishop.setPosition(position.getX(), position.getY());
			}
		}
	}
	
	@Override
	public void selectPiece() {
		// TODO Auto-generated method stub
		
	}

	
}
