package application;


public class Knight extends ChessPiece{

	public Knight(int x, int y, Side side){
		posX = x;
		posY = y;
		this.side = side;
	}
	
	@Override
	public void moveOptions(ChessBoard b) {
		helpmoveOptions(b, 2, 1);
		helpmoveOptions(b, 1, 2);
		helpmoveOptions(b, -1, 2);
		helpmoveOptions(b, -2, 1);
		helpmoveOptions(b, -2, -1);
		helpmoveOptions(b, -1, -2);
		helpmoveOptions(b, 1, -2);
		helpmoveOptions(b, 2, -1);
	}
	
	public void helpmoveOptions(ChessBoard b, int X, int Y){
		for(int i = 0; i < eatOpt.size(); i++) eatOpt.get(i).getWithinTarget().remove(side);
		for(int i = 0; i < moveOpt.size(); i++) moveOpt.get(i).getWithinTarget().remove(side);
		eatOpt.clear();
		moveOpt.clear();
		if(b.withinBoard(posX+X, posY+Y)){
			if(b.t[posX+X][posY+Y] instanceof FTile){
				if(((FTile)b.t[posX+X][posY+Y]).c.side != this.side)eatOpt.add(b.t[posX+X][posY+Y]);
			}
			else moveOpt.add(b.t[posX+X][posY+Y]);
			b.t[posX+X][posY+Y].getWithinTarget().add(side);
			
		}
	}

	@Override
	public ChessPiece clone() {
		return new Knight(this.posX,this.posY,this.side);
	}
	

}
