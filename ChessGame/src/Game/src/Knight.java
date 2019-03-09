package Game.src;
/**
 * This class is a child of the Piece class, and
 * contains the methods of a Knight piece in Chess.
 * @author sabayar
 *
 */

public class Knight extends Piece {

	
	public Knight(int x, int y, String color) {
		super(x, y, color);
	}
	
	public void selectPiece() {
		this.setSelected(true);
		int currentX = this.getPosition().getX();
		int currentY = this.getPosition().getY();

		Position[] allMoves = new Position[8];
		allMoves[0] = new Position(currentX - 2, currentY + 1);
		allMoves[1] = new Position(currentX - 2, currentY - 1);
		allMoves[2] = new Position(currentX + 2, currentY + 1);
		allMoves[3] = new Position(currentX + 2, currentY - 1);
		allMoves[4] = new Position(currentX + 1, currentY - 2);
		allMoves[5] = new Position(currentX - 1, currentY - 2);
		allMoves[6] = new Position(currentX + 1, currentY + 2);
		allMoves[7] = new Position(currentX - 1, currentY + 2);
	
		//TODO: Check which moves are valid from allMoves
		//TODO: Draw indicator on all valid move positions on the board
		//TODO: Check which moves can attack from validMoves
		//TODO: Draw different indicator on all valid attack positions
	}
	
	@Override
	public String toString() {
		return "Knight";
	}
	
}
