package Chess_Game;
public abstract class Piece {
	public Position position;
	public boolean isWhite;
	public boolean isAlive;
	public Piece(boolean isWhite) {
		this.isWhite=isWhite;
		this.isAlive=true;
	}
	public void setPosition(Position pos) {
		this.position = pos;
	}
	
	public Position getPosition() 
	{
		return this.position;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean getIsAlive(){
		return isAlive;
	}
	public abstract boolean checkMove(ChessBoard board,Position start,Position dest);
}