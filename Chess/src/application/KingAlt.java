package application;

import java.util.ArrayList;

public class KingAlt extends ChessPiece{
	
	public KingAlt(int x, int y, Side side){
		posX = x;
		posY = y;
		this.side = side;
	}

	@Override
	public void moveOptions(ChessBoard b) {
		helpmoveOptions(b, 1, 0);
		helpmoveOptions(b, 1, 1);
		helpmoveOptions(b, 0, 1);
		helpmoveOptions(b, -1, 1);
		helpmoveOptions(b, -1, 0);
		helpmoveOptions(b, -1, -1);
		helpmoveOptions(b, 0, -1);
		helpmoveOptions(b, 1, -1);
	}
	
	public void helpmoveOptions(ChessBoard b, int X, int Y){
		for(int i = 0; i < eatOpt.size(); i++) eatOpt.get(i).getWithinTarget().remove(side);
		for(int i = 0; i < moveOpt.size(); i++) moveOpt.get(i).getWithinTarget().remove(side);
		eatOpt.clear();
		moveOpt.clear();
		if(!b.t[posX+X][posY+Y].getWithinTarget().contains(this.otherSide()) && b.withinBoard(posX+X, posY+Y)){
			if(b.withinBoard(posX+X, posY+Y)){ 
				if(b.t[posX+X][posY+Y] instanceof FTile &&((FTile)(b.t[posX+X][posY+Y])).c.side != this.side)eatOpt.add(b.t[posX+X][posY+Y]);
				else {
					moveOpt.add(b.t[posX+X][posY+Y]);
					b.t[posX+X][posY+Y].getWithinTarget().add(this.side);
				}
				
			}
		}
	}

	@Override
	public ChessPiece clone() {
		// TODO Auto-generated method stub
		return new KingAlt(this.posX,this.posY,this.side);
	}

	public boolean helperCheck(ChessBoard b, ArrayList<Tile> moveOpt, ArrayList<Tile> eatOpt){
		if(b.t[posX][posY].getWithinTarget().contains(otherSide())) return true;
		int i;
		for(i = 0; i < moveOpt.size(); i++){
			if(!moveOpt.get(i).getWithinTarget().contains(otherSide())) return false;
		}
		for(i = 0; i < eatOpt.size(); i++){
			if(!eatOpt.get(i).getWithinTarget().contains(otherSide())) return false;
		}
		return true;
	}
	
	
	public boolean Check(ChessBoard b){
		if(b.t[posX][posY].getWithinTarget().contains(otherSide())){
			return true;
		}
		return false;
	} // PLACE IT AT THE END OF THE ENEMY MOVE METHOD!!!
	
}
