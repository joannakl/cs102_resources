package recursion.intro;

import java.lang.IllegalArgumentException; 

public class Palindrome {

	public static void main ( String [] args ) {
        String s = null;  
        if (args.length < 1 ) {
            s = "Hello"; 
        }
        else {
            s =  args[0] ;
        }
        System.out.println( s );        
        System.out.println( isPalindrome(s) ); 
    }
    
    public static boolean isPalindrome(String str) {
        if (str == null ) return false;
        return isPal(str, 0, str.length() );
    } 
    
    public static boolean isPal ( String str, int index, int length ) {
        
        if ( index >= length/2 ) return true;
        
        if ( str.charAt(index) == str.charAt(length - index - 1 ) ) 
            return isPal( str, ++index, length ) ; 
        
        return false; 
    } 
    /*
    public static boolean isPal ( String str ) {
        
        if (str.length() == 0 ) return true;
        if (str.length() == 1 ) return true; 
        
        char c0 = str.charAt(0); 
        char cLast = str.charAt( str.length() - 1); 
        
        if (c0 == cLast) 
            return isPal(str.substring(1,str.length()-1 ) ) ; 
        
        
        return false; 
    }*/
    
}
