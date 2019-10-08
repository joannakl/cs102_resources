package code_examples.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList  implements Iterable<Person> {

	
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
    
    
    public void add( Person p, int pos ) {
    	if (pos<0 || pos > size  ) throw new IllegalArgumentException("bad position"); 
		if (p == null ) throw new IllegalArgumentException("not allowing null"); 
    	
        //empty list 
        if (head == null ){
            head = new Node (p);
            size++;
            return; 
        }
        //adding at pos = 0
        if (pos == 0) {
        	Node n = new Node (p); 
        	n.next = head;
        	head = n;
        	size++;
        	return; 
        }
				
		Node current = head; 
	        
		for ( int i = 0; i < pos-1  ; i++ ) {
			current = current.next; 
		}
		Node n = new Node (p); 
		n.next = current.next; 
        current.next = n; 
        
        size++; 
    	
    }
    
    public Person remove (int pos ) {
    	if (pos<0 || pos >= size  ) throw new IllegalArgumentException("bad position"); 
    	
    	//if (head == null ) return null;    	
    	//pos = 0 
    	if (pos == 0 ) {
    		Node current = head; 
    		head = head.next; 
    		size -- ;
    		return current.person; 
    	}
    	
    	Node prev = head;
    	Node cur = head.next; 
    	int at = 1; 
    	while ( at < pos ) {
    		prev = prev.next; 
    		cur = cur.next; 
    		at++;
    	}
    	prev.next = cur.next; 
    	size--; 
    	
    	return cur.person;
    	
    }
    
    public boolean remove (Person p ) { 
    	
    	return false; 
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
    
    public Person get (int pos ) {
    	if (pos < 0 || pos > size-1) throw new IndexOutOfBoundsException ("too large or too small"); 
    	
    	Node current = head; 
    	int counter = 0; 
    	while (counter < pos ) {
    		current = current.next; 
    		counter ++; 
    	}
    	return current.person; 
    	
    }


	@Override
	public Iterator<Person> iterator() {
		
		Iterator<Person> itr = new Itr(); 
		
		return itr;
	}
	
	private class Itr implements Iterator<Person> {
		
		Node current = head; 
		
		@Override
		public boolean hasNext() {
			
			if (current != null ) 
				return true; 
			
			return false;
		}

		@Override
		public Person next() throws NoSuchElementException {
			
			if (current == null) throw new NoSuchElementException("reached the end of this collection"); 
			Person p = current.person; 
			current = current.next; 
			
			return p;
		}
		
		
	}
	
	
	
	
	
	/*
	
	public int size () { 
		//the simplest way assuming that size data field exists 
		//return size; 
		
		//or 
		Node current = head;
		int counter = 0;
		while (current != null ) {
			counter++;
			current=current.next; 
		}
		return counter; 
	}
	
	public void addBack (Person p ) {
		if (head == null) {
			head = new Node(p) ;
			size++;
			return;
		}
		Node current = head;
		while (current.next != null ) {
			current = current.next;
		}
		current.next = new Node(p) ;
		size++;
	}
	
	public void addFront ( Person p ) {
		Node temp = new Node(p);
		temp.next = head;
		head = temp; 
		size++; 
	}
	
	public Person removeFront( ) {
		if (head == null )
			return null;
		Person temp = head.person;
		head = head.next;
		size--; 
		return temp; 
		
	}
	
	public Person removeBack( ) {
		if (head == null ) return null;
		
		Person temp = null; 
		
		if (head.next == null ) {
			temp = head.person; 
			head = null; 
			return temp;
		}
		
		Node current = head; 
		while (current.next.next != null ) {
			current = current.next; 
		}
		temp = current.next.person; 
		current.next = null; 
		return temp; 
	}
	
	public boolean contains ( Person p ) {
		
		Node current = head;
		
		while (current != null ) {
			if (current.person.equals( p )) {
				return true; 
			}
			current = current.next; 
		}
		
		return false; 
	}
	
	*/
	
}
