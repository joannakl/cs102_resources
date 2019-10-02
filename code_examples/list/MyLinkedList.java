package code_examples.list;

public class MyLinkedList {

	
	class Node {
		Person person;
		Node next; 		
		//default constructor 
		Node () { 
		}
		//one param constructor
		Node ( Person p ) {
			this.person = p;
		}
	}
	
	
	private Node head;
	private int size; 
	

	public MyLinkedList() {
		head = null;
		size = 0; 
	}
	
	
	public void addFront( Person p   ) { 
		if (p == null ) throw new IllegalArgumentException("not allowing null"); 
        
		Node n = new Node(p); 
		n.next = head; 
		head = n; 
		
		size++; 
	}
    
    public void addBack ( Person p ) {
		if (p == null ) throw new IllegalArgumentException("not allowing null"); 
        
        //empty list 
        if (head == null ){
            head = new Node (p);
            size++;
            return; 
        }
        
        //non-empty list 
        Node current = head; 
        
        while ( current.next  != null ) {
            current = current.next; 
        }
        current.next = new Node (p); 
        
        size++; 
        
    }
	
	public int size() { 
        int count = 0; 
        Node current = head; 
        
        while ( current != null ) {
            count++; 
            current = current.next; 
        }
        return count; 
    }
	
	
    public String toString() {
        String  str = ""; 
        Node current = head; 
        
        while ( current != null ) {
            str += current.person + "  " ; 
            current = current.next; 
        }
        return str; 
        
        
    }
	
	
	
	
	
	
	
}
