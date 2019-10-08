package code_examples.list;

import java.util.Iterator;

public class TestLinkedList {


	
	public static void main  (String [] args) {
		
		MyLinkedList list = new MyLinkedList(); 
		list.add( new Person("Jane", 25), 0 );
		list.add( new Person("John", 25), 1);
		list.add( new Person("Ann", 25), 2);
		list.add( new Person("Mary", 25), 3);
		list.add( new Person("Mary", 25), 3);

		System.out.println(list);
		
		/*
		for (Person p : list) {
			System.out.println(p);
		}*/
		
		Iterator<Person> it = list.iterator(); 
		while (it.hasNext()) {
			System.out.println( it.next() );
		}
		
		int counter = 0; 
		while(counter < list.size() ) {
			System.out.println(list.get(counter));
			counter++;
		}
		
        
		list.remove(0); 
        
		
		
		
		System.out.println(list);
        
		
		
		/*
		list.addFront ( new Person("John", 14));
        System.out.println(list);
        
        try {
        	list.addFront (null ); 
        }
        catch ( IllegalArgumentException ex ) {
        	System.out.println("Exception thrown, list should not be changed.");
        	System.out.println(list);
        }
        catch ( Exception ex ) {
        	System.out.println("This should not happen.");
        }
        
        list.addBack( new Person("Ann", 18 ));
        System.out.println(list);
        
        //start a new list 
        list = new MyLinkedList(); 
        list.addBack( new Person("Mike", 20));
        System.out.println(list);
        */
	}
}
