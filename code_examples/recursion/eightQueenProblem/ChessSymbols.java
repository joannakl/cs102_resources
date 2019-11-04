package lecture03.eightQueenProblem;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class ChessSymbols {
	public static void main(String[] args) throws UnsupportedEncodingException {

		char cul = '\u250c';
		char cur = '\u2510';
		char cll = '\u2514';
		char clr = '\u2518';
		char hd = '\u252c';
		char hu = '\u2534';
		char vr = '\u251c';
		char vl = '\u2524';
		char cross = '\u253c';
		String h = "\u2500\u2500\u2500";
		char v = '\u2502';
		String s = "   ";
		
		String middleR = vr+h+cross+h+cross+h+cross+h+cross+h+cross+h+cross+h+cross+h+vl;
		String middleS = v+s+v+s+v+s+v+s+v+s+v+s+v+s+v+s+v;
		String top = cul+h+hd+h+hd+h+hd+h+hd+h+hd+h+hd+h+hd+h+cur;
		String bottom = cll+h+hu+h+hu+h+hu+h+hu+h+hu+h+hu+h+hu+h+clr;
		
		String unicodeMessage = top + "\n" + 
				middleS + "\n" + middleR + "\n"  + 
				middleS + "\n" + middleR + "\n"  + 
				middleS + "\n" + middleR + "\n"  + 
				middleS + "\n" + middleR + "\n"  + 
				middleS + "\n" + middleR + "\n"  + 
				middleS + "\n" + middleR + "\n"  + 
				middleS + "\n" + middleR + "\n"  + 
				middleS + "\n" + bottom + "\n"
				
				
				+ "\u2654 " + // white
																			// king
				"\u2655 " + // white queen
				"\u2656 " + // white rook
				"\u2657 " + // white bishop
				"\u2658 " + // white knight
				"\u2659 " + // white pawn
				"\n" + "\u265A " + // black queen
				"\u265B " + // black queen
				"\u265C " + // black rook
				"\u265D " + // black bishop
				"\u265E " + // black knight
				"\u265F " + // black pawn
				"\n" + "\u2591 " + // black pawn
				"\u2592 " + // black pawn
				"\u25A0 " + // black pawn
				"\u25A1 " + // black pawn
				"\u25A0 " + // black pawn
				"\u25A1 " + // black pawn
				"\n" + "m " + // black pawn
				"i " + // black pawn
				"o " + // black pawn
				"w " + // black pawn
				"l " + // black pawn
				"d " + // black pawn
				"\n" + "m " + // black pawn
				"i " + // black pawn
				"\u25A1 " + // black pawn
				"w " + // black pawn
				"l " + // black pawn
				"d " + // black pawn
				"\n" + "m " + // black pawn
				"i " + // black pawn
				"o " + // black pawn
				"  " + // black pawn
				"l " + // black pawn
				"d " + // black pawn
				"\n";
		PrintStream out = new PrintStream(System.out, true, "UTF8");
		out.println(unicodeMessage);
	}
}