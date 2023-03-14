package Chess_Game;

public class Knight extends Piece {
 private Position position;
	public Knight(boolean isWhite) {
		super(isWhite);

	}
	public boolean checkMove(ChessBoard board,Position start,Position dest) {
		if(dest.x<0 || dest.x>7 || dest.y<0 || dest.y>7) {
			return false;
		}
		//watch all 4 direction's 'L' Shaped
		int[] tx = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
		int[] ty = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
		boolean result = false;

		for(int i=0;i<8;i++) {
			int x = start.x;
			int y = start.y;
			if(x+tx[i]>=0 && x+tx[i]<8 && y+ty[i]>=0 && y+ty[i]<8 && x+tx[i]==dest.x && y+ty[i]==dest.y) 
			{
				result = true;
			}
		}

		return result;

	}
	
}
