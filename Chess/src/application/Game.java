package application;

public class Game {
	Player p1;
	Player P2;
	ChessBoard b;
	
	public static void main(String [] args){
		Player p1 = new Player(Side.White);
		Player P2 = new Player(Side.Black);
		ChessBoard b = new ChessBoard();
	}

}
