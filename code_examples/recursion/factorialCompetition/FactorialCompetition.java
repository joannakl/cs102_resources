
package recursion.factorialCompetition;

import java.lang.IllegalArgumentException; 
import java.util.Date;

/**
 * This program compares running time of factorial methods
 * that use recursion and iterations to compute their results.
 * @author Joanna Klukowska
 * @version Feb 11, 2014 
 *
 */
public class FactorialCompetition {

	/**
	 * @param args
	 *   ignored
	 */
	public static void main(String[] args) {
		
		final int REPEAT = 1000000;
		
		long num = 0, result = 0;
		long start, end;
		  
        if (args.length <1) {
            num = 25; 
        }
        else {
            num = Long.parseLong( args[0] ); 
        }
		
		System.out.printf("Before many calls to recursive factorial(%d).%n%n", num);
		start = (new Date()).getTime();
		for (int i = 0; i < REPEAT; i++)
			result = Factorial01.factorial ( num );
		end =  (new Date()).getTime();
		System.out.printf("%n%d! = %d %n", num, result);
		System.out.printf("recursive factorial took %d milliseconds", end - start);
		

		System.out.printf("%n%nBefore many calls to iterative factorial(%d).%n%n", num);
		start = (new Date()).getTime();
		for (int i = 0; i < REPEAT; i++)
			result = Factorial04Iterative.factorial ( num );
		end =  (new Date()).getTime();
		System.out.printf("%n%d! = %d %n", num, result);
		System.out.printf("iterative factorial took %d milliseconds\n\n", end - start);

	}

}
