package code_examples.iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class Example2 {

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
	    
	    // once the iterator reached the last element, it cannot be "reset"
	    System.out.println(iter.hasNext()); 
	    
	    // but we can use the same reference and get a new iterator
	    iter = list.iterator();
	    
	    System.out.println("Here is the list again");
	    
	    while ( iter.hasNext() ) {
	    	System.out.println( iter.next() ); 
	    }
	    
	    

	}

}
