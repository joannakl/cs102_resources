
package recursion.eightQueenProblem;

import java.util.Random;

/**
 * EightQueenSolver class demonstrates the solutions to the eight queen
 * problem. It provides visual aid for the backtracking solution to the 
 * problem.
 * 
 * @author Joanna Klukowska
 *
 */
public class EightQueenSolver_Console {
	static int SIZE = 8;
	public static void main(String[] args) {
		ChessBoard board = new ChessBoard();

		placeEightQueens(board);
		board.drawChessBoard();
		
	}
	
	/**
	 * Generates a single solution to the eight queen problem.
	 * The chess board object b is modified to include the placement 
	 * of the eight queens.
	 * @param b  ChessBoard to be used for the solution of the 
	 *           eight queen problem
	 */
	public static void placeEightQueens ( ChessBoard b) {
		placeQueen (b, 0 );
	}

	/* 
	 * Search for a solution to eight queen problem starting from 
	 * a specified row. Assumption: all the rows with indexes
	 * from 0 to row-1 already contain queens. 
	 * @param b		the chessboard containing partial solution
	 * @param row   row number to start with
	 * @return		true if it is possible to successfully place queens
	 *              on rows row up to 8 given the current state of the board b.
	 */
	private static boolean placeQueen(ChessBoard b, int row) {
		if (row == SIZE) // Stopping condition
			return true; // A solution found to place 8 queens in 8 rows
		int [] colIndex = shuffeledArray( SIZE );
		
        for (int column = 0; column < SIZE; column++) {
			b.addQueen(row, colIndex[column]); // Place a queen at (row, column)
			b.drawChessBoard();
			//after every step wait some number of milliseconds to create the animation effect 
			try{Thread.sleep(400);}
			catch(InterruptedException e){}
			if (b.isValid(row, colIndex[column]) && placeQueen(b, row + 1))
				return true; // Found, thus return true to exit for loop
        }
		// No solution for a queen placed at any column of this row
        b.resetRow(row); 
		return false;
	}

	/*
	 * Generate an array with size many elements containing unique integers from
	 * zero to size-1 in a random order.
	 * @param size   size of the array
	 * @return       an integer array with size many elements containing unique integers 
	 *               from zero to size-1 in a random order
	 */
	private static int[] shuffeledArray(int size) {
		int [] indexes = new int[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++)
			indexes[i] = i;
		//for (int i = 0; i < size; i++) {
			//int firstInd = rand.nextInt(size);
			//int secondInd = rand.nextInt(size);
			//int tmp = indexes[firstInd];
			//indexes[firstInd] = indexes[secondInd];
			//indexes[secondInd] = tmp;
		//}
		return indexes;
	}

}
