package Chess_Game;
public class Pawn extends Piece {
	private Position position;
	private ChessBoard board;
	public Pawn(boolean isWhite) {
		super(isWhite);
	}
	public boolean checkMove(ChessBoard board,Position start,Position dest) {
		int fromRow=start.x;
		int fromCol=start.y;
		int toRow=dest.x;
		int toCol=dest.y;

		if(fromRow == toRow)
		{
			return false;
		}
		if(fromCol == toCol && toRow-fromRow<=2) {
			if (fromRow < toRow) {
				for (int i = fromRow + 1; i <= toRow; i++)
				{
					if(board.getPiece(new Position(i,fromCol))!=null)
					{
						return false;
					}
					return true;
				}
			} 
		}

		return true;		
	}
}
