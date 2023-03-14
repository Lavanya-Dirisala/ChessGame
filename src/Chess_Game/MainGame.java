package Chess_Game;

public class MainGame {
	private Player black;
	private Player white;	
	private ChessBoard chessBoard;	
	public Player current, other;
	public GameStatus status;
	private Queen queen;
	private Bishop[] bishops;
	private Rook[] rooks;
	private Knight[] knights;
	public MainGame() {
		this.black = new Player(false);
		this.white = new Player(true);		
		this.chessBoard = new ChessBoard(black, white);	
		this.status = GameStatus.ACTIVE;
	}

	//Return -1 if turn is invalid, else return 1. 
	public int makeTurn(boolean whiteTurn, Position start, Position dest) {
		if(whiteTurn) {
			current = white;
			other = black;
		}
		else {
			current = black;
			other = white;
		}

		Piece pieceAtSrc = this.chessBoard.getPiece(start);
		if(pieceAtSrc==null) {
			return -1;
		}
		//Piece color and Player color should be same.
		if(current.isWhite != pieceAtSrc.isWhite) {
			return -1;
		}

		Piece pieceAtDest = chessBoard.getPiece(dest);
		if(pieceAtDest != null && pieceAtSrc.isWhite == pieceAtDest.isWhite) {
			System.out.println("Hi-JACKING YOUR OWN PIECE");
			return -1;
		}

		System.out.println(start.x + " "+ start.y +" "+dest.x+" "+dest.y);
		boolean isValid =  pieceAtSrc.checkMove(chessBoard,start,dest);
		if(!isValid) {
			return -1;
		}
		else{
			pieceAtSrc.setPosition(dest);
			this.chessBoard.setPiece(null, start);
			this.chessBoard.setPiece(pieceAtSrc, dest);
			//killing scenario
			if(pieceAtDest!=null) {
				pieceAtDest.setPosition(new Position(-1, -1));
				pieceAtDest.setIsAlive(false);
			}
			System.out.println("Other  "+other.isWhite + "   Curr  "+ current.isWhite);
			//Check if current's king is getting into danger with this move.
			boolean isCurrentKingSafe = isCheck(other, current);
			//If the current player's king is not safe with the current player's move, move is not valid.
			//Backtrack all the changes made.
			//return true when king is in danger
			if(isCurrentKingSafe) {
				pieceAtSrc.setPosition(start);
				this.chessBoard.setPiece(pieceAtSrc, start);
				if(pieceAtDest != null) {
					pieceAtDest.setIsAlive(true);
					pieceAtDest.setPosition(dest);
					this.chessBoard.setPiece(pieceAtDest,dest);
				}
				else {
					this.chessBoard.setPiece(null, dest);
				}
				return -1;
			}
		}

		return 1;
	}

	public boolean isAttackingSpot(Player otherplayer, Position currentkingdest) {
		boolean flag = false;
		//System.out.println(currentkingdest.x +" "+ currentkingdest.y+"o  "+flag);
		//System.out.print("+++"+player.king.getPosition().x+" "+player.king.getPosition().y+"+++");
		//flag= otherplayer.getKing().checkMove(chessBoard,otherplayer.king.getPosition(),currentkingdest);
		System.out.println(otherplayer.queen.getIsAlive());
		
		if(!flag && otherplayer.queen.isAlive) {
			flag = otherplayer.getQueen().checkMove(chessBoard,otherplayer.queen.getPosition(),currentkingdest);
			//System.out.println("queen flag "+flag);
		}
		
		if(!flag &&otherplayer.knights[0].isAlive) {
			flag = otherplayer.getKnight(0).checkMove(chessBoard,otherplayer.knights[0].getPosition(), currentkingdest);
			//System.out.println(flag);
		}
		
		if(!flag &&otherplayer.knights[1].isAlive) {
			flag = otherplayer.getKnight(1).checkMove(chessBoard,otherplayer.knights[1].getPosition(),currentkingdest);
			//System.out.println(flag);
		}
		
		if(!flag &&otherplayer.rooks[0].isAlive) {
			flag = otherplayer.getRook(0).checkMove(chessBoard,otherplayer.rooks[0].getPosition(),currentkingdest);
			//System.out.println(flag);
		}
		if(!flag &&otherplayer.rooks[1].isAlive) {
			flag = otherplayer.getRook(1).checkMove(chessBoard,otherplayer.rooks[1].getPosition(),currentkingdest);
			//System.out.println(flag);
		}
		if(!flag &&otherplayer.bishops[0].isAlive) {
			flag = otherplayer.getBishop(0).checkMove(chessBoard,otherplayer.bishops[0].getPosition(),currentkingdest);
			//System.out.println(flag);
		}
		if(!flag &&otherplayer.bishops[1].isAlive) {
			flag = otherplayer.getBishop(0).checkMove(chessBoard,otherplayer.bishops[1].getPosition(),currentkingdest);
			//System.out.println(flag);
		}

		return flag;
	}

	public boolean isCheck(Player other, Player current) {

		//Check if other's king is being attacked by curren
		Position currentKingPos = current.king.getPosition();
		boolean check = isAttackingSpot(other, currentKingPos);
		return check;
	}	

	public void startGame(boolean whiteTurn,Position start,Position desc) {
		 status = GameStatus.ACTIVE;
		if(status == GameStatus.ACTIVE ) {
			int ok = this.makeTurn(whiteTurn,start,desc);
			chessBoard.printBoard();
			if(ok==-1)
			{
				System.out.println("Invalid Move made ");
				status = GameStatus.ERROR;
				//System.out.print(status);
			}
			else {
				boolean check = this.isCheck(other, current);
				if(check) {
					if(whiteTurn) {
						status = GameStatus.WHITE_WINS;
					}
					else {
						status = GameStatus.BLACK_WINS;
					}
				}				
			}
		}
	}
}