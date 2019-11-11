package search_sort;

import java.util.Arrays; 

public class QuickSort {
    private static boolean visual = false; 

	public static void main ( String [] args ) {
        
        if (args.length > 0 ){
            if ( args[0].equalsIgnoreCase("visual") )
                visual = true; 
        }
         
         
        String words[] = {"zoo", "hello", "world", "pizza", "apple", "coke", "dinner"}; 
        quickSort( words ); 
        System.out.println( Arrays.toString(words) ); 
        
    }
    
    
    public static void quickSort( String [] array ) { 
        quickSort( array, 0, array.length - 1 ) ;
    }
    public static void quickSort ( String [] array, int left, int right ) { 
        if (visual ) {
            System.out.printf("quickSort, l: %3d, r: %3d\n%s\n\n", 
                left,right, printArray(array,left, right) );
        }
        int pivotIndex = partition ( array, left, right) ;
        if ( pivotIndex - left > 1 ) 
            quickSort( array, left, pivotIndex - 1 );
        if ( right - pivotIndex > 1 )
            quickSort( array, pivotIndex + 1, right );
    }
    
    public static int partition ( String [] array, 
            int left, int right) {
        
        int leftOrg = left; 
        int rightOrg = right; 
                
                
        // find a pivot index first
        int pivotIndex = (left + right)/2; 
        
        if (visual ) {
            System.out.printf("   partition start, l: %3d, r: %3d, pivotIndex: %3d\n   %s\n\n", 
                left, right, pivotIndex, 
                printArray(array,left, right) );
        } 
        
        //move the pivot to the rightmost position 
        swap (array, right, pivotIndex) ;
        
        //shift pivotIndex and right to updated positions
        pivotIndex = right;
        right = right - 1; 
        
        while (left <= right ) { 
            // find the first element in the left part of the array
            // that does not belong (i.e., it is larger than the pivot)
            while ( array[left].compareTo(array[pivotIndex]) < 0 ) 
                left++;
            // find the first from the back element in the right part of 
            // the array that does not belong (i.e., it is smaller than the pivot)
            while ( right >= left && array[right].compareTo(array[pivotIndex])>=0 ) 
                right--;
            // swap both elements so they end up in the parts to whcih they
            // belong 
            if (right > left) {
                swap(array, left, right); 
            }
        }
        //move the pivot element to its final location
        swap (array, left, pivotIndex); 
        
          
        if (visual ) {
            System.out.printf("   partition end, l: %3d, r: %3d, pivotIndex: %3d\n   %s\n\n", 
                left, right, left, 
                printArray(array,leftOrg, rightOrg) );
        } 
        
        
        return left;
    }
    
    public static void swap( String [] array, int ind1, int ind2) {
        String tmp = array[ind1]; 
        array[ind1] = array[ind2];
        array[ind2] = tmp; 
    }
    
    
    public static String printArray(String []array, int left, int right) {
        StringBuilder output = new StringBuilder(); 
        output.append("["); 
        int i = 0;
        for (i = left; i < right; i ++ ) {
            output.append(array[i] + ", " ); 
        }
        output.append(array[i] + "]"); 
        return output.toString(); 
    }
}
 
