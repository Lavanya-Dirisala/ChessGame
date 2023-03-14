package Chess_Game;
public class King extends Piece{
	public Position position;
	private Piece isWhite;
	public King(boolean isWhite) {
		super(isWhite);
	}
	public boolean checkMove(ChessBoard board,Position start,Position dest) {
		int fromRow=start.x;
		System.out.print(start.x);
		int fromCol=start.y;
		int toRow=dest.x;
		int toCol=dest.y;
		if (fromRow < 0 || fromRow > 7 || fromCol < 0 || fromCol > 7 || toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7) 
		{
			return false;
		}
		
		int diffrow=Math.abs(toCol-fromRow);
		int diffcol=Math.abs(diffrow-fromCol);
		if(diffrow < 2 && diffcol < 2 && diffcol+diffrow > 0 ) {
			return true;
		}
		return false;
	}
//	@Override
//	public void setPosition(Position pos) {
//		this.position = pos;
//	}
//	@Override
//	public Position getPosition() {
//		return this.position;
//	}


}
