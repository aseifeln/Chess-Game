package application;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class ChessPiece {
	ArrayList<Tile> eatOpt = new ArrayList<Tile>();
	ArrayList<Tile> moveOpt = new ArrayList<Tile>();
	int posX;
	int posY;
	Side side;
	
	public abstract void moveOptions(ChessBoard b); // CHANGE THE RETURN TYPE!!!

	public ArrayList<Tile> getEatOpt() {
		return eatOpt;
	}
	
	
	
	public void move(ChessBoard b, Tile t){
		if(moveOpt.contains(t)){
			ChessPiece c = this.clone();
			c.posX = t.X;
			c.posY = t.Y;
			t = new FTile(c);
		}
		if(eatOpt.contains(t)) b.outSide.add(((FTile)t).Eat(this,b));
	}
	
	public abstract ChessPiece clone();
	
	public Side otherSide(){
		if(this.side == Side.Black){
			return Side.White;
		}
		return Side.Black;
		
	}
	
	
}
