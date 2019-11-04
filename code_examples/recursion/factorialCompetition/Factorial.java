package recursion.factorialCompetition;

public class Factorial {
	public static void main(String[] args) {
		int d = 24;
		System.out.printf("fact(%d)=%d", d, factorial(d));
	}
	
	public static int factorial ( int n ) {
		int factValue = 1;
		if (n < 0 )
			factValue = 0;
		else if (n == 1 || n == 0) 
			factValue = 1;
		else 
			factValue = n * factorial (n-1);
		return factValue;
	}
}
