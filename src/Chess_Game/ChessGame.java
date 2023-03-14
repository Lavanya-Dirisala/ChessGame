package Chess_Game;
import java.util.Scanner;
public class ChessGame {

	public static void main(String args[]) {
		MainGame main=new MainGame();
		Scanner input=new Scanner(System.in);
		boolean flag=true;
		boolean whiteTurn=true;
		while(flag) {
			if(whiteTurn) {
				System.out.println("WHITE PLAYER");
			}
			else {
				System.out.println("BLACK PLAYER");
			}
			System.out.println("Get start position X and Y axis");
			int fromx = input.nextInt();
			int fromy=input.nextInt();

			System.out.println("Get destination position X and Y axis");
			int tox=input.nextInt();
			int toy=input.nextInt();

			Position start=new Position(fromx,fromy);
			Position desc=new Position(tox,toy);
			if(fromx <0 || fromy >7 || tox <0 || toy>7) {
				System.out.println("Select in between 0 - 7");
			}
			else {
				main.startGame(whiteTurn,start,desc);
				System.out.println("--------"+main.status+"---------");
				if(main.status == GameStatus.ERROR) {
					System.out.println("ChessBoard resulted to ERROR");
					flag=false;
					break;
				}
				if(main.status == GameStatus.WHITE_WINS) {
					System.out.println("White Player Won");
					flag=false;
					break;
				}
				if(main.status == GameStatus.BLACK_WINS) {
					System.out.println("Black Player Won");
					flag=false;
					break;
				}
				whiteTurn=!whiteTurn;
			}
		}
	}

}
