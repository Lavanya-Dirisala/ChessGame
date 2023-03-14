package Chess_Game;
public class Bishop extends Piece {
	private Position position;
	private ChessBoard board;
	public Bishop(boolean isWhite) {
		super(isWhite);
	}	
	public boolean checkMove(ChessBoard board,Position start,Position dest) {
		int fromRow=start.x;
		int fromCol=start.y;
		int toRow=dest.x;
		int toCol=dest.y;
		boolean flag=true;
//		System.out.println(fromRow +" "+ fromCol);
//		System.out.println(toRow +" "+ toCol);
		if(Math.abs(toRow-fromRow)== Math.abs(toCol-fromCol)) {
			return true;
		}
		else {
			//Check for situation where all middle column as empty
			int rowdir=(toRow-fromRow>0)?1:-1;
			int coldir=(toCol-fromCol>0)?1:-1;
			int row=rowdir+fromRow;
			int col=coldir+fromCol;	
			//System.out.println(row +"00"+ col);

			while(flag=true && row!=toRow || col!=toCol) {
				if(board.getPiece(new Position(row,col))== null) {

					System.out.println(board.getPiece(new Position(row,col)));
					//System.out.println(row +"**"+ col);
					row+=rowdir;
					col+=coldir;
				}
				else {
					return false;
				}
			}
		}

		return true;

	}
}