package scraps;

public class Inheritance_4 {

	public static void main (String [] args ) {

		C7 a = new C7();
		C8 b = new C8();
		C7 c = new C8(); 
							
		foo (a);
		foo (b); 
		foo (c); 	// which foo() function runs when this line is executed?
		
		a.print();
		b.print();
		c.print();
	}
	public static void foo ( C7 val ) { 
		val.x = 13; 
	}
	public static void foo ( C8 val ) {
		val.x = 25; 
		val.y = 100; 
	}
}

class C7 {
	public int x; 
	public void print() {
		System.out.println("C7: " + x);
	}
}

class C8 extends C7 {
	public int y; 
	public void print() {
		System.out.println("C8: " + x + ", " + y);
		
	}
}

