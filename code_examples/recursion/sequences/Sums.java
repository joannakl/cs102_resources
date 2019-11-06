package recursion.sequences;

/**
 * This program demonstrates the technique of backtracking using
 * recursive algorithms for deciding if there are values in the 
 * array that add up to some particular target. 
 *  
 * @author Joanna Klukowska
 * @version Nov. 3, 2019
 *
 */
public class Sums {

	public static void main ( String [] args ) {
        int nums[] = {3, 7, 2, 8, 9, 10}; 
        System.out.println( "\n"+groupSum (0, nums, 17 ) );
        System.out.println( "\n"+groupSum (0, nums, 55 ) );
        System.out.println( "\n"+ groupSum (0, nums, 23 ) );
    }


    public static boolean groupSum(int start, int[] nums, int target) {
    
        //base case - we reached the end of the array 
        if (start >= nums.length) 
            return (target == 0);
      

        //pick the  value to be in the sum 
        if ( groupSum(start + 1, nums, target - nums[start]) )  {
            System.out.print( nums[start] + "  ");
            return true;
        }
        //do not include the value in the sum 
        if ( groupSum(start + 1, nums, target) ) 
            return true;

        //if neither of the above worked, it's not possible.
        return false;
    }
    
}
