
package recursion.eightQueenProblem;

import java.util.ArrayList;

/**
 * Class ChessBoard represents an 8x8 chess board.
 * It is NOT a generic chess board. It is designed specifically
 * for solving the eight queen problem.
 *
 * @author Joanna Klukowska
 *
 */
public class ChessBoard {
	//unicode characters for various parts of the chess board drawing
	// corners, verticals, horizontals, sides, etc.
	static private char cul = '\u250c';
	static private char cur = '\u2510';
	static private char cll = '\u2514';
	static private char clr = '\u2518';
	static private char hd = '\u252c';
	static private char hu = '\u2534';
	static private char vr = '\u251c';
	static private char vl = '\u2524';
	static private char cross = '\u253c';
	static private String h = "\u2500\u2500\u2500";
	static private char v = '\u2502';
	static private String s = "   ";
	//chess board parts (a bit bigger than the ones above)
	static private String middleR =
			vr+h+cross+h+cross+h+cross+h+cross+h+cross+h+cross+h+cross+h+vl;
	static private String middleS = v+s+v+s+v+s+v+s+v+s+v+s+v+s+v+s+v;
	static private String top = cul+h+hd+h+hd+h+hd+h+hd+h+hd+h+hd+h+hd+h+cur;
	static private String bottom = cll+h+hu+h+hu+h+hu+h+hu+h+hu+h+hu+h+hu+h+clr;

	//complete blank chess board
	static private String blankBoard = top + "\n" +
			middleS + "\n" + middleR + "\n"  +
			middleS + "\n" + middleR + "\n"  +
			middleS + "\n" + middleR + "\n"  +
			middleS + "\n" + middleR + "\n"  +
			middleS + "\n" + middleR + "\n"  +
			middleS + "\n" + middleR + "\n"  +
			middleS + "\n" + middleR + "\n"  +
			middleS + "\n" + bottom + "\n";

	//storage for the board with some queens in it
	private StringBuffer board;

	//column index for a queen in each row
	private ArrayList <Integer> queens;

	/**
	 * Creates a ChessBoard object with a blank board
	 */
	public ChessBoard () {
		queens = new ArrayList<Integer>();
		for (int i = 0; i < 8; i++)
			queens.add(i, -1);
		board = new StringBuffer( blankBoard );
	}


	/**
	 * Draws the current chess board to the standard output (console window)
	 */
	public void drawChessBoard () {

		board = new StringBuffer( blankBoard );
		for (int row = 0; row < queens.size(); row ++ )
			if (queens.get(row) != -1)
				board.setCharAt(32 + 32*(row*2) + (row+1)*4
						+ (queens.get(row))*4, '\u265B');

		for (int i = 0; i< 30; i++)
			System.out.print("\n");

		System.out.println(board);
		//System.out.print(queens);
	}

	/**
	 * Returns column number for the queen in the i'th row.
	 * Precondition: 0 <= i < 8
	 * @param i	  queen's row
	 * @return    the column at which the queen is located on the i'th row
	 *            or -1 if there is no queen on the i'th row
	 */
	public int getQueen(int i) {
		if (i < 0 || i > 8)
			throw new IllegalArgumentException("Invalid row for the queen.\n");
		return queens.get(i);
	}

	/**
	 * Sets a new queen location for the row to be the given column.
	 * @param row  row number for which the new queen position is set
	 * @param col  new column position for the queen in a given row
	 */
	public void addQueen(int row, int col) {
		if (row < 0 || row > 8)
			throw new IllegalArgumentException("Invalid row for the queen.\n");
		if (col < 0 || col > 8)
			throw new IllegalArgumentException("Invalid column for the queen.\n");
		queens.set(row, col);
	}


	/** Check if a queen can be placed at  position indicated by a row, column pair.
	 *  Assumptions: existing queens on the board are at rows zero up to (but not including)
	 *  row number.
	 * @param row     potential row number for the new queen
	 * @param column  potential column number for the new queen
	 * @return        returns true/false to indicate if the position is a valid
	 *                location of the queen given the current status of the whole board
	 */
	public boolean isValid(int row, int column) {
		for (int i = 1; i <= row; i++)
			if (queens.get(row - i) == column // Check column
				|| queens.get(row - i)  == column - i // Check upleft diagonal
				|| queens.get(row - i)  == column + i) // Check upright diagonal
			{
				queens.set(row, -1);
				return false; // There is a conflict
			}
		return true; // No conflict
	}

    /** Resets the queen position in a given row to nothing to indicate that there
     * is not queen present in that row.
	 * @param row     row number for which there is no queen
	 */
    public void resetRow( int row) {
        queens.set(row, -1);
    }
}
