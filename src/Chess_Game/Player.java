package Chess_Game;
public class Player {
	public boolean isWhite;	
	public King king;
	public Queen queen;
	public Knight[] knights;
	public Bishop[] bishops;
	public Rook[] rooks;
	public Pawn[] pawns;
	
	public Player(boolean isWhite) {
		this.isWhite = isWhite;
		this.king = new King(isWhite);
		this.queen = new Queen(isWhite);
		this.knights = new Knight[2];
		knights[0] = new Knight(isWhite);
		knights[1] = new Knight(isWhite);
		this.bishops=new Bishop[2];
		bishops[0]=new Bishop(isWhite);
		bishops[1]=new Bishop(isWhite);
		this.rooks=new Rook[2];
		rooks[0]=new Rook(isWhite);
		rooks[1]=new Rook(isWhite);
		this.pawns=new Pawn[8];
		for(int i=0;i<8;i++) {
			pawns[i]=new Pawn(isWhite);
		}
	}
	
	public Piece getRook(int i) {
		return rooks[i];
	}

	public Piece getKnight(int i) {
		return knights[i];
	}

	public Piece getBishop(int i) {
		return bishops[i];
	}

	public Piece getKing() {
		return king;
	}

	public Piece getQueen() {
		return queen;
	}

	public Piece getPawn(int i) {
	return pawns[i];
	}
}