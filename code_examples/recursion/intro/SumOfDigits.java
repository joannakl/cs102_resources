package recursion.intro;

public class SumOfDigits {

	public static void main ( String [] args ) {
        String text = null; 
        if (args.length > 0 ) 
            text = args[0];
        else 
            text = "Hello 123 !!!";
            
        int sum1 = sumIter(text);
        int sum2 = sumRec(text);
        
        System.out.println(sum1); 
        System.out.println(sum2); 
        
    }
    
    public static int sumIter( String text ) {
        int sum = 0;
        char c; 
        if (text == null || text.equals(""))
            return 0;
        for (int i = 0; i < text.length(); i++){
            c = text.charAt(i) ; 
            if ( Character.isDigit( c ) ) {
                sum += c - '0'; 
            }
        }
        return sum; 
    }
    
    //wrapper function 
    public static int sumRec( String text ) {
        //error checking
        //special case check 
        if (text == null )
            return 0; 
        else return sumRecHelp( text );
    }
    
    public static int sumRecHelp( String text ) {
        
        
        //base case that will stop the recursive calls 
        if (text.equals("") ) 
            return 0; 
            
        //recusrive case     
        char c = text.charAt(0); 
        if ( Character.isDigit( c ) ) 
            return  (c - '0') + sumRecHelp( text.substring(1) );
        return sumRecHelp( text.substring(1) );
        
    }

}
