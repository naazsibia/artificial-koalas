package Game;
/**
 * This class is a child of the Piece class, and
 * contains the methods of a Pawn
 * @author Jonathan Martin
 *
 */

public class Pawn extends Piece {
	
	//Pawns can move up to 2 spaces on their first move. The variable hasMoved will keep track of if the first move has happened.
	private Boolean hasMoved;
	
	public Pawn(int x, int y, String color) {
		super(x, y, color);
		this.hasMoved = false; //At the start of the game, the pawn has not yet moved
	}
	
	public void selectPiece() {
		this.selected = true;
		int currentX = this.getPosition().getX();
		int currentY = this.getPosition().getY();
		
		Position[] validMoves = new Position[] {new Position(currentX, currentY + 1)};
		if (this.hasMoved == false) {
			validMoves[validMoves.length] = new Position(currentX, currentY + 2);
		}
		
		Position[] attackMoves = new Position[] {
				new Position(currentX + 1, currentY + 1),
				new Position(currentX - 1, currentY + 1)
		};
		//TODO: Check if target in attack positions
		
		//TODO: Draw indicator on all valid move positions
		//TODO: Draw indicator on all valid attack positions
	}
	
}
