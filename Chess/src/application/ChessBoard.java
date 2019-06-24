package application;

import java.util.ArrayList;

public class ChessBoard {
	Tile[][] t = new Tile[8][8];
	ArrayList<ChessPiece> outSide = new ArrayList<ChessPiece>();
	KingAlt WK;
	KingAlt BK;
	
	public static void main(String[] args){
		Tile[] s = new Tile[5];
		System.out.println(s[0]);
		s[0]= new FTile(new King());
		System.out.println(s[0]);
		
	}
	
	public void move(Tile from, Tile to){
		((FTile)from).c.move(this, to);
		int x = from.X;
		int y = from.Y;
		from = new ETile(x,y);
		Refresh();
		if(((FTile)to).c.side==Side.Black) WCheck();
		else BCheck();
	}
	
	public void Refresh(){
		for(int i = 0; i < t.length; i++){
			for(int j = 0; j < t[i].length; j++){
				t[i][j].getWithinTarget().clear();
			}
		}
		for(int i = 0; i < t.length; i++){
			for(int j = 0; j < t[i].length; j++){
				if(t[i][j] instanceof FTile) ((FTile)t[i][j]).c.moveOptions(this);
			}
		}
	}
	
	//public ChessBoard(){	}
	
	public boolean WCheck(){
		return t[WK.posX][WK.posY].getWithinTarget().contains(Side.Black);
	}
	
	public boolean BCheck(){
		return t[BK.posX][BK.posY].getWithinTarget().contains(Side.White);
	}
	
	
	
	public Tile KnightPrevent(FTile in, Side s, int X, int Y){
		if(withinBoard(in.X+X, in.Y+Y)){
			if(t[in.X+X][in.Y+Y] instanceof FTile && t[in.X+X][in.Y+Y].getWithinTarget().contains(s)) return t[in.X+X][in.Y+Y];	
		}
		return null;
	}
	
	
	public ArrayList<Tile> Prevent(FTile in, Side s){
		ArrayList<Tile> nb = new ArrayList<Tile>();
		for(int i = 0; i < in.c.eatOpt.size(); i++){
			if(!in.c.eatOpt.get(i).getWithinTarget().contains(in.c.otherSide())) nb.add(in.c.eatOpt.get(i));
		}
		for(int i = 0; i < in.c.moveOpt.size(); i++){
			if(!in.c.moveOpt.get(i).getWithinTarget().contains(in.c.otherSide())) nb.add(in.c.moveOpt.get(i));
		}
		nb.addAll(helpPreventOptions(in, s, 1, 0));
		nb.addAll(helpPreventOptions(in, s, 1, 1));
		nb.addAll(helpPreventOptions(in, s, 0, 1));
		nb.addAll(helpPreventOptions(in, s, -1, 1));
		nb.addAll(helpPreventOptions(in, s, -1, 0));
		nb.addAll(helpPreventOptions(in, s, -1, -1));
		nb.addAll(helpPreventOptions(in, s, 0, -1));
		nb.addAll(helpPreventOptions(in, s, 1, -1));
		nb.add(KnightPrevent(in, s, 2, 1));
		nb.add(KnightPrevent(in, s, 1, 2));
		nb.add(KnightPrevent(in, s, -1, 2));
		nb.add(KnightPrevent(in, s, -2, 1));
		nb.add(KnightPrevent(in, s, -2, -1));
		nb.add(KnightPrevent(in, s, -1, -2));
		nb.add(KnightPrevent(in, s, 1, -2));
		nb.add(KnightPrevent(in, s, 2, -1));
		while(!nb.contains(null)){
			nb.remove(null);
		}
		return nb;
	}
	
	public ArrayList<Tile> helpPreventOptions(FTile in, Side side, int X, int Y){
		ArrayList<Tile> res = new ArrayList<Tile>();
		int i;
		for(i = 1; t[in.X+(X*i)][in.Y+(Y*i)] instanceof ETile && this.withinBoard(in.X+(X*i), in.Y+(Y*i)) && t[in.X+(X*i)][in.Y+(Y*i)].getWithinTarget().contains(in.c.otherSide()); i++){
			if(t[in.X+(X*i)][in.Y+(Y*i)].getWithinTarget().contains(side))res.add(this.t[in.X+(X*i)][in.Y+(Y*i)]);
		}
		if(this.withinBoard(in.X+(X*i), in.Y+(Y*i))&& ((FTile)(this.t[in.X+(X*i)][in.Y+(Y*i)])).getWithinTarget().contains(side)){ res.add(this.t[in.X+(X*i)][in.Y+(Y*i)]); res.add(this.t[in.X+(X*i)][in.Y+(Y*i)]);}
		return res;
	}
	
	public boolean withinBoard(int m, int n){
		return (m>=0 && m < 8 && n >= 0 && m < 8)? true: false;
	}
	
	
}
