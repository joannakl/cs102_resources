package code_examples.inheritance;

public class Inheritance_2 {

	public static void main (String [] args ) {

		C3 a = new C3();
		C4 b = new C4(3.5f, 15);
		
		//C3 c = new C4(5f, 20);  // is this allowed? 
		//C4 d = new C3(); 		// is this allowed? 	
	}
}

class C3 {
	
	public C3 () { 
		System.out.println("C3()");
	}
	public C3 ( int c ) { 
		System.out.println("C3(int)");
	}
}

class C4 extends C3 {
	protected float c;
	public C4 ( float c, int x ) {
		//super( x );   //uncomment this line to see how the output changes 
		System.out.println("C4(float,int)");
	}	
}