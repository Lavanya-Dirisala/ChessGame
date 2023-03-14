package Chess_Game;
public class Rook extends Piece{
	private Position position;
	private ChessBoard board;
	public Rook(boolean isWhite) {
		super(isWhite);
	}
	public boolean checkMove(ChessBoard board,Position start,Position dest) {
		int fromRow=start.x;
		int fromCol=start.y;
		int toRow=dest.x;
		int toCol=dest.y;
		if (fromRow == toRow && fromCol == toCol)
		{
			return false;
		}
		if (fromRow == toRow) {
			// Horizontal - same row different column
			if (fromCol < toCol) {
				// Move right ->
				for (int i = fromCol + 1; i <= toCol; i++)
					if (board.getPiece(new Position(fromRow, i)) != null)
						return false;
			} else {
				// Move left <-
				for (int i = fromCol - 1; i >= toCol; --i)
					if (board.getPiece(new Position(fromRow, i))!= null)
						return false;
			}
		} else if (fromCol == toCol) {
			// Vertical move
			if (fromRow < toRow) {
				// Move down
				for (int i = fromRow + 1; i <= toRow; ++i)
					if (board.getPiece(new Position(i,fromCol)) != null)
						return false;
			} else {
				// Move up
				for (int i = fromRow - 1; i >= toRow; --i)
					if (board.getPiece(new Position(i,fromCol)) != null)
						return false;
			}
		} 
		else {
			return false;
		}

		return true;
	}


}
