package scraps;

public class Inheritance_3 {

	public static void main (String [] args ) {

		C5 a = new C5();
		C6 b = new C6();
		
		C5 c = new C6(); 
					
		a.sayHi();
		b.sayHi();
		c.sayHi();		//which classes' function will be executed? 
	}
	
}

class C5 {
	public void sayHi() {
		System.out.println("C5 says hi");
	}
}

class C6 extends C5 {
	public void sayHi() {
		System.out.println("C6 says hi");
		
	}
}

