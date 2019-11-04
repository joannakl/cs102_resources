
package recursion.factorialCompetition;

/**
 * This program computes factorial of a number.
 * This is the second recursive attempt to implement factorial function.
 * It displays extra information about the recursive calls.
 * @author Joanna Klukowska
 * @version Feb 11, 2014 
 *
 */
public class Factorial02 {

	/**
	 * @param args
	 *   ignored
	 */
	public static void main(String[] args) {
		
		long num = 0, result = 0;
		
		num = 5;
		
		System.out.printf("Before call to factorial(%d).%n%n", num);
		//compute the value of num!
		result = factorial ( num );
		
		System.out.printf("%n%d! = %d %n", num, result);

	}
	
	/**
	 * Computes factorial function of a given number.
	 * This function displays extra information about the recursive calls
	 * that are being made.
	 * @param number
	 *    number for which we want to compute the factorial 
	 * @return
	 *    value of number! (or gibberish if number is too big)
	 */
	public static long factorial ( long number ) {
		
		long tmpResult = 1;
		
		System.out.printf("facotrial(%d) called %n", number);
		//base case
		if (number == 0 ) 
			tmpResult =  1;
		//recursive case
		else 
			tmpResult = number * factorial ( number - 1 );

		System.out.printf("facotrial(%d) finished, result is %d %n", number, tmpResult);
		
		return tmpResult;
	}

}
