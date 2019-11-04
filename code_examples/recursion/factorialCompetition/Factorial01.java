package recursion.factorialCompetition;

/**
 * This program computes factorial of a number.
 * This is the first recursive attempt to implement factorial function.
 * @author Joanna Klukowska
 * @version Feb 11, 2014 
 *
 */
public class Factorial01 {

	
	/**
	 * @param args command line arguments (ignored) 
	 */
	public static void main(String[] args) { 
		long num = 0, result = 0;
		
		num = 5;
		
		System.out.printf("Before call to factorial(%d).%n%n", num);
		//compute the value of num!
		result = factorial ( num );
		
		System.out.printf("%d! = %d %n", num, result);

	}
	
	/**
	 * Computes factorial function of a given number.
	 * @param number
	 *    number for which we want to compute the factorial 
	 * @return
	 *    value of number! (or gibberish if number is too big)
	 */
	public static long factorial ( long number ) {
		
		//base case
		if (number == 0 ) 
			return 1;
		//recursive case
		else 
			return number * factorial ( number - 1 );
		
	}

}
