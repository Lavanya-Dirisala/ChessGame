package Chess_Game;
public class ChessBoard {
private Piece[][] board;
	public ChessBoard(Player black, Player white) {
		this.board = new Piece[8][8];
		for(int row=0;row<8;row++) {
			for(int col=0;col<8;col++) {
				this.board[row][col] = null;
			}
		}
		//Whites
		//Placing Rook
		this.board[0][0] = white.getRook(0);
		white.getRook(0).setPosition(new Position(0, 0));		
		this.board[0][7] = white.getRook(1);
		white.getRook(1).setPosition(new Position(0, 7));
		
		//Placing Knight
		this.board[0][1] = white.getKnight(0);
		white.getKnight(0).setPosition(new Position(0, 1));
		this.board[0][6] = white.getKnight(1);
		white.getKnight(1).setPosition(new Position(0, 6));
		
		//Placing Bishop
		this.board[0][2] = white.getBishop(0);
		white.getBishop(0).setPosition(new Position(0, 2));
		this.board[0][5] = white.getBishop(1);
		white.getBishop(1).setPosition(new Position(0, 5));
		
		//Placing King and Queen
		this.board[0][3] = white.getKing();
		white.getKing().setPosition(new Position(0, 3));
		this.board[0][4] = white.getQueen();
		white.getQueen().setPosition(new Position(0, 4));
		

		//white.getPawn(1).setPosition(new Position(1, 0));
		//Placing pawn
		for(int col=0;col<8;col++) {
			this.board[1][col] = white.getPawn(col);
			white.getPawn(col).setPosition(new Position(1, col));			
		}
		
		//Blackes
		//Placing Rook
				this.board[7][0] = black.getRook(0);
				black.getRook(0).setPosition(new Position(7, 0));		
				this.board[7][7] = black.getRook(1);
				black.getRook(1).setPosition(new Position(7, 7));
				
				//Placing Knight
				this.board[7][1] = black.getKnight(0);
				black.getKnight(0).setPosition(new Position(7, 1));
				this.board[7][6] = black.getKnight(1);
				black.getKnight(1).setPosition(new Position(7, 6));
				
				//Placing Bishop
				this.board[7][2] = black.getBishop(0);
				black.getBishop(0).setPosition(new Position(7, 2));
				this.board[7][5] = black.getBishop(1);
				black.getBishop(1).setPosition(new Position(7, 5));
				
				//placing King and Queen

				this.board[7][3] = black.getKing();
				black.getKing().setPosition(new Position(7, 3));
				this.board[7][4] = black.getQueen();
				black.getQueen().setPosition(new Position(7, 4));
				
				//Placing Pawns
				for(int i=0;i<8;i++) {
					this.board[6][i] = black.getPawn(i);
					black.getPawn(i).setPosition(new Position(6, i));			
				}
			}   
	public void printBoard() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(board[i][j]!=null)
				System.out.print(+ board[i][j].position.x + " "+board[i][j].position.y+" | ");
				else {
					System.out.print("Null|");
				}
			}
			System.out.println();
		}
	}
	public void setPiece(Piece piece, Position pos) {
		this.board[pos.x][pos.y] = piece;
	}
	public Piece getPiece(Position pos) {
		return this.board[pos.x][pos.y];
	}
}
