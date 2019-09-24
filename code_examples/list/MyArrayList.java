package code_examples.list;

import java.util.Arrays;

public class MyArrayList <E> {
	
	private Object[] list;
	
	private int size;
	private int capacity;
	
	private final int INITIAL_CAPACITY = 10; 
	
	public MyArrayList() {
		list = new Object [ INITIAL_CAPACITY];
		size = 0;
		capacity = INITIAL_CAPACITY;
	}
	
	public MyArrayList( int cap ) throws IllegalArgumentException {
		if (cap <= 0 ) throw new IllegalArgumentException("capacity has to be positive"); 
		capacity = cap;
		size = 0; 
		list = new Object [ capacity ];
	}
	public void add ( E item ) throws IllegalArgumentException, MaxCapacityExceededException {
		
		add(item,size); 
	}
	

	/**
	 * @param item
	 * @param pos
	 * @throws IllegalArgumentException when the parameter item is null 
	 * @throws IndexOutOfBoundsException when the parameter pos is too small or too large 
	 * @throws MaxCapacityExceededException when the
	 */
	public void add ( E item , int pos) 
			throws IllegalArgumentException, IndexOutOfBoundsException, MaxCapacityExceededException 
	{
		
		if (item == null ) 
			throw new IllegalArgumentException( "null elements not allowed in this collection") ;
		if (pos < 0 || pos > size ) 
			throw new IndexOutOfBoundsException (
					"invalid position, not within valid positions of 0 to "+size); 
		if (size == capacity ) {
			grow(); 
		}
		for (int i = size; i > pos; i--) {
			list[i] = list[i-1]; 
		}
		list[pos] = item;
		size++;
	}
	
	@Override 
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(list, 0, size) ); 
	}
	
	
	
	public E get ( int pos ) throws IndexOutOfBoundsException {
		if (pos < 0 || pos > size ) 
			throw new IndexOutOfBoundsException (""
					+ "invalid position, not within valid positions of 0 to "+size); 
		
		return (E) list[pos] ; 
	}
	
	
	
	
	public E remove (int pos ) throws IndexOutOfBoundsException {
		if (pos < 0 || pos > size ) 
			throw new IndexOutOfBoundsException (
					"invalid position, not within valid positions of 0 to "+size); 
		
		Object item = list[pos]; 
		
		for (int i = pos; i < size-1; i++) {
			list[pos] = list[pos+1]; 
		}
		size--; 
		
		return (E) item  ; 
	}
	
	public boolean contains ( E item ) throws IllegalArgumentException {

		if (item == null ) 
			throw new IllegalArgumentException( "null elements not allowed in this collection") ;
		
		
		// this does not work! WHY ? 
		for (int i = 0; i < size; i++ ) {
			
			if (item.equals( list[i] ) ) return true; 
		}
		
		return false; 
	}
	
	
	
	
	public int size() {
		return size; 
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		MyArrayList<E> other = (MyArrayList<E>) obj;
		
		if (!Arrays.deepEquals(list, other.list))
			return false;
		
		if (size != other.size)
			return false;
		
		
        if (list == other.list)
            return true;
        if (list == null || other.list==null)
            return false;
        
        for (int i = 0; i < size; i++) {
            Object e1 = list[i];
            Object e2 = other.list[i];

            if (e1 == e2)
                continue;
            if (e1 == null)
                return false;

            // Figure out whether the two elements are equal
            boolean eq = e1.equals(e2);
            if (!eq)
                return false;
        }
     
		return true;
	}

	
	
	
	private void grow() throws MaxCapacityExceededException {
		if (capacity == Integer.MAX_VALUE)
			throw new MaxCapacityExceededException("the list cannot grow anymore"); 
		
		int newCapacity = capacity + capacity>>2; 
        
		if (newCapacity < 0 ) {
			newCapacity = Integer.MAX_VALUE;
		}
		
		Object [] newList = new Object[newCapacity]; 
		for (int i = 0; i < size; i++) {
			newList[i] = list[i];
		}
		
		capacity = newCapacity;
		list = newList; 
	}
	
	
	
	
}
 