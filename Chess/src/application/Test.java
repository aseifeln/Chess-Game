package application;

import java.util.ArrayList;

public class Test {
	
	public static void main(String [] args){
		/*ChessPiece c = new QueenAlt();
		System.out.println(""+c);
		ChessPiece calt = (ChessPiece) c.clone();
		System.out.println(""+calt);*/
		
		ArrayList<Integer> in = new ArrayList<Integer>();
		in.add(null);
		in.add(5);
		System.out.println(in.size());
		System.out.println(in.get(1));
		in.remove(0);  
		System.out.println(in.size());
		//System.out.println(in.get(0));   //null is concidered an object;
	}

}
