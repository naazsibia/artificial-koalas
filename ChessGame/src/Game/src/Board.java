import java.util.Observable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This class functions as the game board and stores
 * information on the current board state
 * 
 * @author: Jonathan Martin
 *   
 */
public class Board extends Observable implements EventHandler<ActionEvent> {
	/**
	 * @return the buttonHandler
	 */
	public PieceHandlerCaller getButtonHandler() {
		return buttonHandler;
	}



	/**
	 * @param buttonHandler the buttonHandler to set
	 */
	public void setButtonHandler(PieceHandlerCaller buttonHandler) {
		this.buttonHandler = buttonHandler;
	}


	//The boardModel stores an 8 x 8 double array that contains the current state of the board
	private PieceButton[][] boardModel;
	private int currentPlayer;
	private PieceButton selectedPiece;
	private PieceHandlerCaller buttonHandler; 
	private PieceButton blackKing;
	private PieceButton whiteKing;
	public Board() {
		this.boardModel = new PieceButton[8][8];
		buttonHandler = new PieceHandlerCaller(this);
		// Create 64 PieceButtons, one for each position on the board 
		boolean isWhite = true;
		for (int x = 0; x < 8; x = x + 1) {
			PieceButton[] row = new PieceButton[8];
			for (int y = 0; y < 8; y = y+1) {
				//The defaultPiece() function returns the piece 
				//that is in the specified position at the start of the game
				Piece defaultPiece = defaultPiece(x, y);
				if (isWhite) {
					row[y] = new PieceButton(new Position(x, y), true, defaultPiece, 0);
				} 
				else {
					row[y] = new PieceButton(new Position(x, y), true, defaultPiece, 1);
				}
				// Store kings to check if they are unsafe
				if(defaultPiece != null && defaultPiece.type().equals("King")) {
					if(defaultPiece.getColor().equals("black")) blackKing = row[y];
					else whiteKing = row[y];
				}
				row[y].setOnAction(this);
				isWhite = !isWhite;
			}
			this.boardModel[x] = row;
			isWhite = !isWhite;
		}

		this.currentPlayer = 0;
		switchTurn();
		this.selectedPiece = null;
	}



	/**
	 * @return the blackKing
	 */
	public PieceButton getBlackKing() {
		return blackKing;
	}



	/**
	 * @param blackKing the blackKing to set
	 */
	public void setBlackKing(PieceButton blackKing) {
		this.blackKing = blackKing;
	}



	/**
	 * @return the whiteKing
	 */
	public PieceButton getWhiteKing() {
		return whiteKing;
	}



	/**
	 * @param whiteKing the whiteKing to set
	 */
	public void setWhiteKing(PieceButton whiteKing) {
		this.whiteKing = whiteKing;
	}



	public void switchTurn() {
		// Switches the current player
		// When the current player changes, 
		// all pieces of the previous player are set so that they cannot be selected
		// and all the pieces of the new current player are set so that they can be selected
		String colour;
		if(this.currentPlayer == 0) {
			this.currentPlayer = 1;
			colour = "white";
		}else {
			this.currentPlayer = 0;
			colour = "black";
		}
		for(int row = 0; row < 8; row ++) {
			for(int col = 0; col < 8; col++) {
				PieceButton button = boardModel[row][col];
				Piece piece = button.getPiece();
				if(piece != null && !(piece.getColor().equals(colour))){
					button.setCanSelect(false);
				}
				else if(piece != null) {
					button.setCanSelect(true);
				}
			}
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

	private Piece defaultPiece(int x, int y) {
		// This helper method gives the Piece that is the given position at the start of the game.
		// By default the Piece is null
		Piece piece = null;

		//If the Piece is in the first 2, or last 2 rows, there will be a piece there by default
		if(x == 0 || x == 1 || x == 6 || x == 7) {

			// By default the colour of the piece is black, if it is in the last 2 rows it is white
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



	@Override
	public void handle(ActionEvent event) {
		buttonHandler.handlerCaller(event);

	}



	public void notifyView() {
		setChanged(); 
		// trying to notify view
		notifyObservers(this);
		
	}
	
	public void reset() {
		//resets the board state to be in the starting state
		this.boardModel = new PieceButton[8][8];
		buttonHandler = new PieceHandlerCaller(this);
		boolean isWhite = true;
		for (int x = 0; x < 8; x = x + 1) {
			PieceButton[] row = new PieceButton[8];
			for (int y = 0; y < 8; y = y+1) {
				Piece defaultPiece = defaultPiece(x, y);
				if (isWhite) {
					row[y] = new PieceButton(new Position(x, y), true, defaultPiece, 0);
				} 
				else {
					row[y] = new PieceButton(new Position(x, y), true, defaultPiece, 1);
				}
				// Store kings to check if they are unsafe
				if(defaultPiece != null && defaultPiece.type().equals("King")) {
					if(defaultPiece.getColor().equals("black")) blackKing = row[y];
					else whiteKing = row[y];
				}
				row[y].setOnAction(this);
				isWhite = !isWhite;
			}
			this.boardModel[x] = row;
			isWhite = !isWhite;
		}

		this.currentPlayer = 0;
		switchTurn();
		this.selectedPiece = null;
	}
}
