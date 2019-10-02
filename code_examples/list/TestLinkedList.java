package code_examples.list;

public class TestLinkedList {


	
	public static void main  (String [] args) {
		
		MyLinkedList list = new MyLinkedList(); 
		list.addFront( new Person("Jane", 25) );
        System.out.println(list);
        
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
	}
}
