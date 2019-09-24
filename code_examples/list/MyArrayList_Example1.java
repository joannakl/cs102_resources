package code_examples.list;

public class MyArrayList_Example1 {


	public static void main(String[] args)  {
		
		Integer [] vals = {10, 15, 34, null, -15 }; 
		int [] pos = {0, 1, 5, 1, 1} ; 
		MyArrayList<Integer> numList = new MyArrayList<> ();
		
		for (int i = 0; i < vals.length; i++ ) {
			try {
				numList.add(vals[i], pos[i]);
			} 
			catch (IllegalArgumentException e) {
				System.out.println("item " + vals[i] + " was not added at postion " + pos[i]);
				System.out.println(e.getClass() + " exception caught");
				System.out.println("message: " + e.getMessage() + "\n");
				
			} 
			catch (IndexOutOfBoundsException e) {
				System.out.println("item " + vals[i] + " was not added at postion " + pos[i]);
				System.out.println(e.getClass() + " exception caught");
				System.out.println("message: " + e.getMessage());
			} 
			catch (MaxCapacityExceededException e) {
				System.out.println("item " + vals[i] + " was not added at postion " + pos[i]);
				System.out.println(e.getClass() + " exception caught");
				System.out.println("message: " + e.getMessage() + "\n");
			}
			
			System.out.println("list: " +  numList + "\n");
		}
	}

}
