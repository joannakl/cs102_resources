
package recursion.fibonacciCompetition;

import java.util.Date;

/**
 * This program compares running time of Fubonacci methods
 * that use recursion and iterations to compute their results.
 * @author Joanna Klukowska
 * @version Feb 11, 2014 
 *
 */
public class FibonacciCompetition {

	/**
	 * @param args
	 *   ignored
	 */
	public static void main(String[] args) {
		
		final int REPEAT = 100000;
		
		long num = 0, result = 0;
		long start, end;
		
        if (args.length <1) {
            num = 5; 
        }
        else {
            num = Long.parseLong( args[0] ); 
        }
		
		System.out.printf("Before many calls to recursive Fibonacci(%d).%n%n", num);
		start = (new Date()).getTime();
		for (int i = 0; i < REPEAT; i++)
			result = Fibonacci01.fibonacci(num);
		end =  (new Date()).getTime();
		System.out.printf("%nFibonacci(%d) = %d %n", num, result);
		System.out.printf("recursive factorial took %d milliseconds", end - start);
		

		System.out.printf("%n%nBefore many calls to iterative Fibonacci(%d).%n%n", num);
		start = (new Date()).getTime();
		for (int i = 0; i < REPEAT; i++)
			result = Fibonacci03Iterative.fibonacci(num);
		end =  (new Date()).getTime();
		System.out.printf("%nFibonacci(%d) = %d %n", num, result);
		System.out.printf("iterative factorial took %d milliseconds", end - start);
        
        System.out.printf("\n\n\n"); 

	}

}
