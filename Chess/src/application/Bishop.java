package application;

import java.util.ArrayList;



public class Bishop extends ChessPiece {
	
	public Bishop(int x, int y, Side side){
		posX = x;
		posY = y;
		this.side = side;
	}
	
	public void moveOptions(ChessBoard b) {
		moveOpt.clear();
		moveOpt.addAll(helpmoveOptions(b, 1, 1));
		moveOpt.addAll(helpmoveOptions(b, -1, 1));
		moveOpt.addAll(helpmoveOptions(b, 1, -1));
		moveOpt.addAll(helpmoveOptions(b, -1, -1));
		
	}
	
	public ArrayList<Tile> helpmoveOptions(ChessBoard b,int X, int Y){
		for(int i = 0; i < eatOpt.size(); i++) eatOpt.get(i).getWithinTarget().remove(side);
		for(int i = 0; i < moveOpt.size(); i++) moveOpt.get(i).getWithinTarget().remove(side);
		eatOpt.clear();
		moveOpt.clear();
		ArrayList<Tile> res = new ArrayList<Tile>();
		int i;
		for(i = 1; b.t[posX+(X*i)][posY+(Y*i)] instanceof ETile && b.withinBoard(posX+(X*i), posY+(Y*i)); i++){
			res.add(b.t[posX+(X*i)][posY+(Y*i)]);
			b.t[posX+(X*i)][posY+(Y*i)].getWithinTarget().add(this.side);
		}
		if(b.withinBoard(posX+(X*i), posY+(Y*i))){ if(((FTile)(b.t[posX+(X*i)][posY+(Y*i)])).c.side != this.side) eatOpt.add(b.t[posX+(X*i)][posY+(Y*i)]); res.add(b.t[posX+(X*i)][posY+(Y*i)]);}
		for(i = 0; i < eatOpt.size();i++) ((FTile)eatOpt.get(i)).c.moveOptions(b);
		return res;
	}

	@Override
	public ChessPiece clone() {
		// TODO Auto-generated method stub
		return new Bishop(this.posX,this.posY,this.side);
	}}
