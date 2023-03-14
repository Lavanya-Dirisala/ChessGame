package Chess_Game;

public class Queen extends Piece {
	private ChessBoard board;
	private Position position;
	public Queen(boolean isWhite) {
		super(isWhite);
	}
	public boolean checkMove(ChessBoard board,Position start,Position dest) {
		int fromRow=start.x;
		int fromCol=start.y;
		int toRow=dest.x;
		int toCol=dest.y;
		//Bishop Logic 
		if(toRow<fromRow || toCol<fromCol) {
			if(Math.abs(toCol-fromRow)== Math.abs(toCol-fromCol)) {
				return true;
			}
			//Check for situation where all middle column as empty
			int rowdir=(toRow-fromRow>0)?1:-1;
			int coldir=(toCol-fromCol>0)?1:-1;
			int row=rowdir+fromRow;
			int col=coldir+fromCol;	
			while(row!=toRow&& col!=toCol) {
				if(board.getPiece(new Position(row,col))!= null) {
					return false;
				}
				row+=rowdir;
				col+=coldir;
			}
		}
		//Rook Logic
		if (fromRow == toRow && fromCol == toCol)
		{
			return false;
		}
		if (fromRow == toRow)
		{
			// Horizontal - same row different column
			if (fromCol < toCol) {
				// Move right ->
				for (int i = fromCol + 1; i <= toCol; i++)
					if (board.getPiece(new Position(fromRow,i))!= null)
						return false;
			} else {
				// Move left <-
				for (int i = fromCol - 1; i >= toCol; --i)
					if (board.getPiece(new Position(fromRow,i)) != null)
						return false;
			}
		} 
		if (fromCol == toCol) {
			// Vertical move
			if (fromRow < toRow) {
				// Move down
				for (int i = fromRow + 1; i <= toRow; ++i)
					if (board.getPiece(new Position(i,fromCol)) != null)
						return false;
			} else {
				// Move up
				for (int i = fromRow - 1; i >= toRow; --i)
					if (board.getPiece(new Position(i,fromCol))!= null)
						return false;
			}
		} 
		else {
			return false;
		}
		return true;
	}

}
