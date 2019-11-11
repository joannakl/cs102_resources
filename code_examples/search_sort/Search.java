package recursion.search;

import java.util.Arrays; 

public class Search {

	public static void main ( String [] args ) {
        
        // which search algorithm would be better here: 
        //  linear search O(N) or binary search O(logN)  (sort it first O(N^2) )   
         
        String words[] = {"hello", "world", "apple", "coke", "dinner"}; 
        Arrays.sort(words); 
        System.out.println( Arrays.toString(words) ); 
        
        System.out.println( linear(words,"world") ); 
        System.out.println( binSearch(words,"world" , 0, words.length -1 ) ) ; 
        
    }
    
    
    public static int binSearch( String [] list, String key, int start, int end ) {
        
        int mid = (end + start) / 2; 
        
        if (list[mid].equals(key) ) {
            return mid; 
        }
        if (end < start )
            return -1; 
            
        if (key.compareTo( list[mid] ) < 0 ) {
            
            return binSearch(list,key,start, mid-1); 
        }
        else {
            return binSearch(list,key,mid+1,end); 
        }
    }
    
    // can you write this recursively? 
    
    public static int linear ( String [] list, String key ) {
        
        for (int i = 0; i < list.length; i++ ){
            if (list[i].equals(key) )
                return i;
        }
        return -1; 
    }
    
    public static int linearRec ( String [] list, String key ) {
        return linearRec(list,key, 0) ; 
    }
    
    public static int linearRec ( String [] list, String key, int index ) {
        
        if (index == list.length )
            return -1 ; 
        
        if (list[index].equals( key ) ) 
            return index ; 
        
        return linearRec(list, key, index+1) ;
    }
    
    
}
