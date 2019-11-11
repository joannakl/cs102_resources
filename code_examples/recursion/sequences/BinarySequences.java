package recursion.sequences;

/**
 * This program demonstrates the technique of backtracking using
 * recursive algorithms for generation of binary sequences of a 
 * specified length and with added constraints.
 *  
 * @author Joanna Klukowska
 * @version August 4, 2015, updated Nov. 3, 2019
 *
 */
public class BinarySequences {

	public static void main ( String [] args ) {
		int length = 4; 
		getAllBinarySequences(length);
		System.out.println("Remove sequences with 1 in the third bit: ");
		getSomeBinarySequences(length);
		System.out.println("Remove sequences with two or more 0 bits: ");
		getNoTwoZerosBinarySequences(length);
		
	}
	
	/**
	 * Generate all binary sequences of the specified length. 
	 * @param length the length of the sequences to be generated 
	 */
	public static void getAllBinarySequences ( int length ) {
		String seq = new String () ;
		getAllBinarySequences( length, seq);
	}
		
	/* Generate all binary sequences of a specified length 
	 * using the seq String as storage for partial sequences. 
	 * @param length the length of the sequence to be generated 
	 * @param seq stores partial sequences between recursive calls  
	 */
	private static void getAllBinarySequences ( int length, String seq ) {
		if (seq.length() == length ) {//reached the desired length
			System.out.printf("%s %n", seq );
		}
		else { //add the next bits to the sequence (two possibilities) 
            
			String seq0 = seq + "0"; //add zero to the current sequence 
			getAllBinarySequences( length, seq0); 
			String seq1 = seq + "1"; //add one to the current sequence
			getAllBinarySequences( length, seq1);
		}
	}
	
	/**
	 * Generate all binary sequences of the specified length with added 
	 * constraint that the third bit is never one. 
	 * @param length the length of the sequences to be generated 
	 */
	public static void getSomeBinarySequences ( int length ) {
		String seq = new String () ;
		getSomeBinarySequences( length, seq);
	}
	
	/*
	 * Generate all binary sequences of the specified length with added 
	 * constraint that the third bit is never one. seq is used for storage
	 * of partial sequences. 
	 * @param length the length of the sequences to be generated 
	 * @param seq stores partial sequences between recursive calls  
	 */
	private static void getSomeBinarySequences ( int length, String seq  ) {
		if (seq.length() == length ) {//reached the desired length
			System.out.printf("%s %n", seq.toString() );
		}
		else if (seq.length() == 2 ) { 
			String seq0 = seq + "0"; //add zero to the current sequence 
			getSomeBinarySequences( length, seq0); 
		}
		else { //add the next bits to the sequence (two possibilities) 
			String seq0 = seq + "0"; //add zero to the current sequence 
			getSomeBinarySequences( length, seq0); 
			String seq1 = seq + "1"; //replace the zero with one
			getSomeBinarySequences( length, seq1);
		}
	}

	
	/**
	 * Generate all binary sequences of the specified length with added 
	 * constraint that no sequence has more than two zeros. 
	 * @param length the length of the sequences to be generated 
	 */
	public static void getNoTwoZerosBinarySequences ( int length ) {
		String seq = new String () ;
		getNoTwoZerosBinarySequences( length, seq, 0 );
	}
	
	/*
	 * Generate all binary sequences of the specified length with added 
	 * constraint that no sequence has more than two zeros. seq is used for storage
	 * of partial sequences. 
	 * @param length the length of the sequences to be generated 
	 * @param seq stores partial sequences between recursive calls  
	 */
	private static void getNoTwoZerosBinarySequences ( int length, String seq, int zeroCount  ) {
		//count the number of zero bits and do not continue
		//if it is equal to two 

        if (seq.length() == length ) {//reached the desired length
            System.out.printf("%s %n", seq.toString() );
        }
        else { //add the next bits to the sequence (two possibilities) 
            if (zeroCount < 2 ){
                String seq0 = seq + "0"; //add zero to the current sequence 
                getNoTwoZerosBinarySequences( length, seq0, zeroCount+1 ); 
            }
            String seq1 = seq + "1"; //replace the zero with one
            getNoTwoZerosBinarySequences( length, seq1, zeroCount);
        }
    
	}
	

}
