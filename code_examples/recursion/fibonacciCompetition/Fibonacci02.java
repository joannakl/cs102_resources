/**
 * 
 */
package recursion.fibonacciCompetition;

/**
 * This program computes n^th Fibonacci number.
 * This is the second recursive attempt to implement Fibonacci numbers.
 * This program prints extra information about the recursive calls.
 * Fibonacci sequence  assumed in this program is:
 *   0 1 1 2 3 5 8 13 21 34 55 89 ...
 * @author Joanna Klukowska
 * @version Feb 11, 2014 
 *
 */
public class Fibonacci02 {

	/**
	 * @param args
	 *   ignored
	 */
	public static void main(String[] args) {
		
		long num = 0, result = 0;
		
		num = 10; 
		
		System.out.printf("Before call to Fibonacci(%d).%n%n", num);
		//compute the value of Fibonacci(num)
		result = fibonacci ( num, 0 );
		
		System.out.printf("Fibonacci(%d) = %d %n", num, result);

	}
	
	/**
	 * Computes fibonacci function of a given number.
	 * @param number
	 *    number for which we want to compute the fibonacci value 
	 * @return
	 *    value of fibonacci(number) (or gibberish if number is too big)
	 */
	public static long fibonacci ( long number, int level ) {
		long tmpResult = 1;
		char [] tab = new char[level*2];
		for (int i = 0; i < tab.length; i++) 
			tab[i] = ' ';
		String tabString = new String(tab);
		
		System.out.printf("%sfibonacci(%d) called %n", tabString, number);
		
		//base case
		if (number == 0 ) 
			return 0;
		else if (number == 1 ) 
			tmpResult = 1;
		//recursive case
		else 
			tmpResult = fibonacci( number - 1, level+1 ) + fibonacci(number - 2, level+1);

		System.out.printf("%sfibonacci(%d) finished, result is %d %n", 
				tabString, number, tmpResult);
		
		return tmpResult;
	}

}
