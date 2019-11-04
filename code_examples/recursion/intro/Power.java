package recursion.intro;

import java.lang.IllegalArgumentException; 

public class Power {

	public static void main ( String [] args ) {
        double b;
        int e;  
        if (args.length <2) {
            b = 5.0;
            e = 3; 
        }
        else {
            b = Double.parseDouble( args[0] ) ;
            e = Integer.parseInt( args[1] ); 
        }
        
        System.out.printf( "%15.3f\n", power( b, e ) ); 
        System.out.printf( "%15.3f\n", powerRec( b, e ) ); 
        
    }
    
    // what is the performance of this funciton? 
    // O(exp) 
    public static double power ( double base, int exp ) {
        
        if (exp < 0 ) throw new IllegalArgumentException("negative exponent"); 
        
        double power = 1;
        while (exp > 0 ){
            power = power * base;
            exp--;
        }
        
        return power; 
    }
    
    
    public static double powerRec ( double base, int exp ) {
        
        System.out.printf("called powerRec(%f,%d)\n", base,exp); 
        
        if (exp < 0 ) throw new IllegalArgumentException("negative exponent"); 
              
        if (exp == 0 ) {
            return 1; 
        }
        double val = powerRecHelp(base, exp);
        
        System.out.printf("returnded %f \n", val); 
        return val; 
    }
    
    public static double powerRecHelp ( double base, int exp ) {
        
        System.out.printf("called powerRecHelp(%f,%d)\n", base,exp); 
        double val; 
        // base case 
        if (exp == 1 ) {
            return base; 
        }
        //recursive case 
        double x = powerRecHelp(base, exp/2 ) ;
        
        if (exp % 2 == 1 ){
            val = x * x  * base;
            
            System.out.printf("returnded %f \n", val); 
            return val; 
        }
        val = x*x; 
        System.out.printf("returnded %f \n", val); 
        return val; 
    }
    
    /*
    public static double powerRecHelp ( double base, int exp ) {
        
        
        if (exp == 0 ) {
            return 1; 
        }
        
        
        return  base * powerRecHelp(base, exp-1) ; 
    }
     */
    
}
