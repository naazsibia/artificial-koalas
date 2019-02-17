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
	
	public Pawn(int x, int y) {
		super(x, y);
		this.hasMoved = false; //At the start of the game, the pawn has not yet moved
	}
	
	public void selectPiece() {
		this.selected = true;
		private int currentX = this.getPosition().getX();
		private int currentY = this.getPosition().getY();
		
		public Position[] validMoves = new Position[] {Position(currentX, currentY + 1)};
		if (this.hasMoved == false) {
			appendValue(validMoves, Position(currentX, currentY + 2));
		}
		
		public Position[] attackMoves = new Position[] {
				Position(currentX + 1, currentY + 1),
				Position(currentX - 1, currentY + 1)
		};
		//TODO: Check if target in attack positions
		
		//TODO: Draw indicator on all valid move positions
		//TODO: Draw indicator on all valid attack positions
	}
	
}
