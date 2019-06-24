package application;


public class FTile extends Tile{
	ChessPiece c;
	
	public FTile(ChessPiece c){
		this.c = c;
		this.X=c.posX;
		this.Y=c.posY;
	}
	
	public ChessPiece Contains(){
		return c;
	}
	
	public ChessPiece Eat(ChessPiece e, ChessBoard b){
		e.posX = c.posX;
		e.posY = c.posY;
		ChessPiece r = c.clone();
		c = e;
		c.moveOptions(b);
		return r;
	}
	
	**public void Move(ChessPiece e, Tile t){
		
	}
	
	



	
	
	
	
}
