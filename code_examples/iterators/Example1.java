package code_examples.iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class Example1 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
	    
	    list.add("Warsaw"); 
	    list.add("Venice");
	    list.add("Atlanta");
	    list.add("New York");
	    list.add("Rome");
	    
	    // this is a correct way of using an iterator
	    
	    Iterator<String> iter = list.iterator();
	    
	    while ( iter.hasNext() ) {
	    	System.out.println( iter.next() ); 
	    }
	    
	    // this is not a good idea since the second call
	    // to next() may not be able to return a valid element 
	    
	    Iterator<String> iterBad = list.iterator();
	    
	    while ( iterBad.hasNext() ) {
	    	System.out.println( iterBad.next() ); 
	    	System.out.println( iterBad.next() ); 
	    }

	}

}
