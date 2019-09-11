package scraps;

public class Inheritance_1 {
	
	public static void main (String [] args ) {

		C1 a = new C1();
		C2 b = new C2(3.5f, 15);
		//C2 c = new C2();
				
		System.out.println( a.x );
		System.out.println(b.c + "  " + b.x  ); 	
	}
}

class C1 { 
	protected int x;
	public void setX (int x ) {
		this.x = x;
	}
}

class C2 extends C1 {
	protected float c;
	public C2 ( float c, int x ) {
		this.c = c;
		setX(x);
		//super.setX(x); 
	}	
}
