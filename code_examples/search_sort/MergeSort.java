package search_sort;

import java.util.Arrays; 

public class MergeSort {
    private static boolean visual = false; 
    
	public static void main ( String [] args ) {
        
        if (args.length > 0 ){
            if ( args[0].equalsIgnoreCase("visual") )
                visual = true; 
        }
         
        String words[] = {"zoo", "hello", "world", "apple", "coke", "dinner"}; 
        mergeSort( words ); 
        System.out.println( Arrays.toString(words) ); 
        
    }
    
    
    public static void mergeSort( String [] array ) { 
        mergeSort (array, 0, array.length-1); 
    }
    public static void mergeSort ( String [] array, int firstIndex, int lastIndex ) { 
        if (visual ) {
            System.out.printf("mergeSort, l: %3d, r: %3d\n%s\n\n", 
                firstIndex,lastIndex, printArray(array,firstIndex, lastIndex) );
        }
        //base case
        if (firstIndex >= lastIndex)
            return; 
        //split the array
        int mid = (firstIndex+lastIndex)/2;
        mergeSort(array, firstIndex, mid);
        mergeSort(array, mid+1, lastIndex);
        merge( array, firstIndex, mid, mid+1, lastIndex);
    }
    
    public static void merge ( String [] array, 
            int leftFirst, int leftLast, 
            int rightFirst, int rightLast ) {
        
        if (visual ) {
            System.out.printf("   merge start, lF: %3d, lL: %3d, rF: %3d, rL: %3d\n   %s\n\n", 
                leftFirst, leftLast, rightFirst, rightLast, 
                printArray(array,leftFirst, rightLast) );
        }        
        //create tmp array whose size equals (rightLast - leftFirst + 1 )
        String tmp [] = new String [rightLast - leftFirst + 1] ; 
        
        //setup initial indexes for each array 
        int indexLeft = leftFirst;
        int indexRight = rightFirst;
        int index = 0; 
        
        // as long as both arrays have at least one element, 
        // pick the smaller one
        while (indexLeft <= leftLast  &&  indexRight <= rightLast ) {
            if (array[indexLeft].compareTo(array[indexRight]) < 0 ) {
                tmp[index]= array[indexLeft];
                ++indexLeft; 
            }
            else {
                tmp[index] = array[indexRight]; 
                ++indexRight;
            }
            ++index; 
        }
        // copy elements in range indexLeft-leftLast to tmp 
        while (indexLeft <= leftLast ) {
            tmp[index]= array[indexLeft];
            ++indexLeft; 
            ++index;
        }
            
        // copy elements in range indexRight-rightLast to tmp
        while (indexRight <= rightLast ) {
            tmp[index] = array[indexRight]; 
            ++indexRight;
            ++index;
        }
        // copy tmp to array starting at leftFirst  
        for (int i = 0; i < tmp.length; i++ ) {
            array[leftFirst+i] = tmp[i];
        }
        
        
        if (visual ) {
            System.out.printf("   merge end, lF: %3d, lL: %3d, rF: %3d, rL: %3d\n   %s\n\n", 
                leftFirst, leftLast, rightFirst, rightLast, 
                printArray(array,leftFirst, rightLast) );
        }
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
