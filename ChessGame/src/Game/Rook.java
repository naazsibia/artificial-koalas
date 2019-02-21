package Game;
/**
 * This is a child of the Piece class, and
 * contains the methods of a Rook
 * @author Jonathan Martin
 *
 */

public class Rook extends Piece {
	
	public void selectPiece() {
		this.selected = true;
		Position[] valid = this.legalMoves();
		
		//TODO: Draw indicator for all valid move positions
		
	}
	
	public Position[] legalMoves() {
		// Currently returns all Positions in the Rook's row and column
		// TODO: Do not return the Rook's current Position
		// TODO: Do not return any Position that is blocked by another Piece
		
		
		Position[] legal = new Position[];
		
		int verticalPos = 0;
		int horizontalPos = 0;
		
		while (verticalPos <= 7) {
			appendValue(legal, Position(this.getPosition().getX(), verticalPos));
			verticalPos = verticalPos + 1;
		}
		
		while (horizontalPos <= 7) {
			appendValue(legal, Position(horizontalPos, this.getPosition().getY()));
			horizontalPos = horizontalPos + 1;
		}
		
		return legal;
		
	}

}
