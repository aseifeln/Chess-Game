package application;

import java.util.ArrayList;
import application.Tile;



public class King extends ChessPiece{

	@Override
	public ArrayList<Tile> moveOptions(ChessBoard b) {
		ArrayList<Tile> res = new ArrayList<Tile>();
		if(!b.t[posX+1][posY].isWithinTarget() && b.withinBoard(posX+1, posY)){
			if(b.withinBoard(posX+1, posY)) eatOpt.add(b.t[posX+1][posY+1]);
			res.add(b.t[posX+1][posY]);
			b.t[posX+1][posY].setWithinTarget(true);
		}
		if(!b.t[posX+1][posY+1].isWithinTarget() && b.withinBoard(posX+1, posY+1)) {
			if(b.withinBoard(posX+1, posY+1)) eatOpt.add(b.t[posX+1][posY+1]);
			res.add(b.t[posX+1][posY+1]);
			b.t[posX+1][posY+1].setWithinTarget(true);
		}
		if(!b.t[posX][posY+1].isWithinTarget() && b.withinBoard(posX, posY+1)){
			if(b.withinBoard(posX, posY+1)) eatOpt.add(b.t[posX+1][posY+1]);
			res.add(b.t[posX][posY+1]);
			b.t[posX][posY+1].setWithinTarget(true);
		}
		if(!b.t[posX-1][posY+1].isWithinTarget() && b.withinBoard(posX-1, posY+1)){
			if(b.withinBoard(posX-1, posY+1)) eatOpt.add(b.t[posX+1][posY+1]);
			res.add(b.t[posX-1][posY+1]);
			b.t[posX-1][posY+1].setWithinTarget(true);
		}
		if(!b.t[posX-1][posY].isWithinTarget() && b.withinBoard(posX-1, posY)) {
			if(b.withinBoard(posX-1, posY)) eatOpt.add(b.t[posX+1][posY+1]);
			res.add(b.t[posX-1][posY]);
			b.t[posX-1][posY].setWithinTarget(true);
		}
		if(!b.t[posX-1][posY-1].isWithinTarget() && b.withinBoard(posX-1, posY-1)){
			if(b.withinBoard(posX-1, posY-1)) eatOpt.add(b.t[posX+1][posY+1]);
			res.add(b.t[posX-1][posY-1]);
			b.t[posX-1][posY-1].setWithinTarget(true);
		}
		if(!b.t[posX][posY-1].isWithinTarget() && b.withinBoard(posX, posY-1)){
			if(b.withinBoard(posX, posY-1)) eatOpt.add(b.t[posX+1][posY+1]);
			res.add(b.t[posX][posY-1]);
			b.t[posX][posY-1].setWithinTarget(true);
		}
		if(!b.t[posX+1][posY-1].isWithinTarget() && b.withinBoard(posX+1, posY-1)){
			if(b.withinBoard(posX+1, posY-1)) eatOpt.add(b.t[posX+1][posY+1]);
			res.add(b.t[posX+1][posY-1]);
			b.t[posX+1][posY-1].setWithinTarget(true);
		}
		return res;
	}
	
	

	
	

}
