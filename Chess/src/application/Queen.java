package application;

import java.util.ArrayList;


public class Queen extends ChessPiece{

	@Override
	public ArrayList<Tile> moveOptions(ChessBoard b) {
		ArrayList<Tile> res = new ArrayList<Tile>();
		int i;
		for(i = 1; b.t[posX+i][posY+i] instanceof ETile && b.withinBoard(posX+i, posY+i); i++){
			res.add(b.t[posX+i][posY+i]);
			b.t[posX+i][posY+i].setWithinTarget(true);
		}
		if(b.withinBoard(posX+i, posY+i)){ eatOpt.add(b.t[posX+i][posY+i]); res.add(b.t[posX+i][posY+i]);}
		for(i = 1; b.t[posX-i][posY+i] instanceof ETile && b.withinBoard(posX-i, posY+i); i++){
			res.add(b.t[posX-i][posY+i]);
			b.t[posX-i][posY+i].setWithinTarget(true);
		}
		if(b.withinBoard(posX-i, posY+i)){ eatOpt.add(b.t[posX-i][posY+i]); res.add(b.t[posX-i][posY+i]);}
		for(i = 1; b.t[posX-i][posY-i] instanceof ETile && b.withinBoard(posX-i, posY-i); i++){
			res.add(b.t[posX-i][posY-i]);
			b.t[posX-i][posY-i].setWithinTarget(true);
		}
		if(b.withinBoard(posX-i, posY-i)){ eatOpt.add(b.t[posX-i][posY-i]); res.add(b.t[posX-i][posY-i]);}
		for(i = 1; b.t[posX+i][posY-i] instanceof ETile && b.withinBoard(posX+i, posY-i); i++){
			res.add(b.t[posX+i][posY-i]);
			b.t[posX+i][posY-i].setWithinTarget(true);
		}
		if(b.withinBoard(posX+i, posY-i)){ eatOpt.add(b.t[posX+i][posY-i]); res.add(b.t[posX+i][posY-i]);}
		for(i = 1; b.t[posX+i][posY] instanceof ETile && b.withinBoard(posX+i, posY); i++){
			res.add(b.t[posX+i][posY]);
			b.t[posX+i][posY].setWithinTarget(true);
		}
		if(b.withinBoard(posX+i, posY)){ eatOpt.add(b.t[posX+i][posY]); res.add(b.t[posX+i][posY]);}
		for(i = 1; b.t[posX][posY+i] instanceof ETile && b.withinBoard(posX, posY+i); i++){
			res.add(b.t[posX][posY+i]);
			b.t[posX][posY+i].setWithinTarget(true);
		}
		if(b.withinBoard(posX, posY+i)){ eatOpt.add(b.t[posX][posY+i]); res.add(b.t[posX][posY+i]);}
		for(i = 1; b.t[posX][posY-i] instanceof ETile && b.withinBoard(posX, posY-i); i++){
			res.add(b.t[posX][posY-i]);
			b.t[posX][posY-i].setWithinTarget(true);
		}
		if(b.withinBoard(posX, posY-i)){ eatOpt.add(b.t[posX][posY-i]); res.add(b.t[posX][posY-i]);}
		for(i = 1; b.t[posX-i][posY] instanceof ETile && b.withinBoard(posX-i, posY); i++){
			res.add(b.t[posX-i][posY]);
			b.t[posX-i][posY].setWithinTarget(true);
		}
		if(b.withinBoard(posX-i, posY)){ eatOpt.add(b.t[posX-i][posY]); res.add(b.t[posX-i][posY]);}
		return res;
	}
	
	public ArrayList<Tile> helpmoveOptions(ChessBoard b,int X, int Y){
		ArrayList<Tile> res = new ArrayList<Tile>();
		int i;
		for(i = 1; b.t[posX+(X*i)][posY+(Y*i)] instanceof ETile && b.withinBoard(posX+(X*i), posY+(Y*i)); i++){
			res.add(b.t[posX+(X*i)][posY+(Y*i)]);
			b.t[posX+(X*i)][posY+(Y*i)].setWithinTarget(true);
		}
		if(b.withinBoard(posX+(X*i), posY+(Y*i))){ eatOpt.add(b.t[posX+(X*i)][posY+(Y*i)]); res.add(b.t[posX+(X*i)][posY+(Y*i)]);}
		return res;
	}
	

}
