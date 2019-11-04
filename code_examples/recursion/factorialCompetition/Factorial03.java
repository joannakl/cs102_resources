
package recursion.factorialCompetition;

/**
 * This program computes factorial of a number.
 * This is the third recursive attempt to implement factorial function.
 * It displays extra information about the recursive calls.
 * @author Joanna Klukowska
 * @version Feb 11, 2014 
 *
 */
public class Factorial03 {

	/**
	 * @param args
	 *   ignored
	 */
	public static void main(String[] args) {
		
		long num = 0, result = 0;
		
		num = 5;
		
		System.out.printf("Before call to factorial(%d).%n%n", num);
		//compute the value of num!
		result = factorial ( num, 0 );
		
		System.out.printf("%n%d! = %d %n", num, result);

	}
	
	/**
	 * Computes factorial function of a given number.
	 * This function displays extra information about the recursive calls
	 * that are being made.
	 * @param number
	 *    number for which we want to compute the factorial 
	 * @param level
	 *    keeps track of how deep in recursive calls we are
	 * @return
	 *    value of number! (or gibberish if number is too big)
	 */
	public static long factorial ( long number, int level ) {
		
		long tmpResult = 1;
		char [] tab = new char[level*2];
		for (int i = 0; i < tab.length; i++) 
			tab[i] = ' ';
		String tabString = new String(tab);
		
		System.out.printf("%sfacotrial(%d) called %n", tabString, number);
		//base case
		if (number == 0 ) 
			tmpResult =  1;
		//recursive case
		else 
			tmpResult = number * factorial ( number - 1, level + 1 );

		System.out.printf("%sfacotrial(%d) finished, result is %d %n", 
				tabString, number, tmpResult);
		
		return tmpResult;
	}

}
