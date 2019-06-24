package application;

import java.util.ArrayList;



public class Pawn extends ChessPiece{
	
	public Pawn(int x, int y, Side side){
		posX = x;
		posY = y;
		this.side = side;
	}

	@Override
	public void moveOptions(ChessBoard b) {
		eatOpt.clear();
		moveOpt.clear();
		if(side == Side.Black){
			moveOpt.add(b.t[posX][posY+1]);
			if(posY == 1) moveOpt.add(b.t[posX][posY+2]);
			helperEatOption(b, 1, 1);
			helperEatOption(b, -1, 1);
		}
		else{
			moveOpt.add(b.t[posX][posY-1]);
			if(posY == 6) moveOpt.add(b.t[posX][posY-2]);
			helperEatOption(b, 1, -1);
			helperEatOption(b, -1, -1);
		}
		
		
	}
	
	public void helperEatOption(ChessBoard b, int X, int Y){
		if(b.t[posX+X][posY+Y] instanceof FTile) if(((FTile)b.t[posX+X][posY+Y]).c.side != this.side) eatOpt.add(b.t[posX+X][posY+Y]);
	}

	@Override
	public ChessPiece clone() {
		return new Pawn(this.posX,this.posY,this.side);
	}
	
	

}
