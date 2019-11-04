/**
 * 
 */
package recursion.fibonacciCompetition;

/**
 * This program computes n^th Fibonacci number.
 * This is the iterative implementation of Fibonacci numbers.
 * Fibonacci sequence  assumed in this program is:
 *   0 1 1 2 3 5 8 13 21 34 55 89 ...
 * @author Joanna Klukowska
 * @version Feb 11, 2014 
 *
 */
public class Fibonacci03Iterative {

	/**
	 * @param args
	 *   ignored
	 */
	public static void main(String[] args) {
		
		long num = 0, result = 0;
		
		num = 6;
		
		System.out.printf("Before call to Fibonacci(%d).%n%n", num);
		//compute the value of Fibonacci(num)
		result = fibonacci ( num );
		
		System.out.printf("Fibonacci(%d) = %d %n", num, result);

	}
	
	/**
	 * Computes fibonacci function of a given number.
	 * @param number
	 *    number for which we want to compute the fibonacci value 
	 * @return
	 *    value of fibonacci(number) (or gibberish if number is too big)
	 */
	public static long fibonacci ( long number ) {
		
		
		//base case
		if (number == 0 ) 
			return 0;
		else if (number == 1 ) 
			return 1;
		//recursive case
		else {
			long tmp1 = 0;
			long tmp2 = 1;
			long result = 0;
			int counter = 2;
			while ( counter <= number) {
				result = tmp1 + tmp2;
				tmp1 = tmp2;
				tmp2  = result;
				counter++;
			}
			
			return result;
 		}
		
	}

}
