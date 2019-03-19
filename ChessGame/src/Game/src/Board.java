/**
 * This class functions as the game board and stores
 * information on the current board state
 * 
 * @author: Jonathan Martin
 *   
 */
public class Board {
	private PieceButton[][] boardModel;
	private int currentPlayer;
	private PieceButton selectedPiece;

	public Board() {
		this.boardModel = new PieceButton[8][8];
		// Create 64 PieceButtons, one for each position on the board 
		for (int x = 0; x < 8; x = x+1) {
			PieceButton[] row = new PieceButton[8];
			for (int y = 0; y < 8; y = y+1) {
				row[y] = new PieceButton(new Position(y, x), false, defaultPiece(y, x), (x+y)%2);

				this.boardModel[x] = row;
			}
		}

			this.currentPlayer = 0;
			this.selectedPiece = null;
		}

		public void switchTurn() {
			if(this.currentPlayer == 0) {
				this.currentPlayer = 1;
			}else {
				this.currentPlayer = 0;
			}
		}

		public PieceButton[][] getBoardModel() {
			return this.boardModel;
		}

		public int getCurrentPlayer() {
			return this.currentPlayer;
		}

		public PieceButton getSelectedPiece() {
			return this.selectedPiece;
		}

		public void setSelectedPiece(PieceButton pb) {
			this.selectedPiece = pb;
		}

		private Piece defaultPiece(int y, int x) {
			// This helper method gives the Piece that is the given position at the start of the game.
			// By default the Piece is null
			Piece piece = null;

			//If the Piece is in the first 2, or last 2 rows, there will be a piece there by default
			if(x == 0 || x == 1 || x == 6 || x == 7) {

				// By defult the colour of the piece is black, if it is in the last 2 rows it is white
				String colour = "black";
				if(x == 6 || x == 7) {
					colour = "white";
				}

				// By default the Piece is a pawn, if it should a different piece it is changed to that
				piece = new Pawn(y, x, colour);

				if(x == 0 || x == 7) {
					// Based on the column the Piece is in it will be a different Piece by default
					// Column 0 and column 7 = Rook
					// Column 1 and column 6 = Knight
					// Column 2 and column 5 = Bishop
					// Column 3 = Queen 
					// Column 4 = King
					if(y == 0 || y == 7) {
						piece = new Rook(y, x, colour);
					}
					else if (y == 1 || y == 6) {
						piece = new Knight(y, x, colour);
					}
					else if (y == 2 || y == 5) {
						piece = new Bishop(y, x, colour);
					}
					else if (y == 3) {
						piece = new Queen(y, x, colour);
					}
					else if (y == 4) {
						piece = new King(y, x, colour);
					}
				}
			}

			return piece;
		}
	}
