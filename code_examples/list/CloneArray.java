package code_examples.list;

public class CloneArray {

	public static void main(String[] args) {
		
		Person contacts [] = new Person[6];
		
		Person guests[]; 
		
		contacts[0] = new Person("John", 18);
		contacts[1] = new Person("Cortney", 19);
		contacts[2] = new Person("Alan", 20);
		contacts[3] = new Person("Jane", 25);
		contacts[4] = new Person("Eva", 18);
		contacts[5] = new Person("Ashley", 22);
		
		//guests = contacts; 
		
		
		guests = new Person[6]; 
		
		for (int i = 0; i < contacts.length; i++) {
			guests[i] =    (Person) contacts[i].clone() ;
		}
		
	
		guests[0].setAge( 50 );
		//guests[0] = new Person("Mike", 15);
		//guests[0].setAge( 50 );
		
		System.out.println("Contacts: ");
		for (Person p : contacts) {
			System.out.println( "\t" +  p  );
		}
		
		System.out.println("\n\nGuests: ");
		for (Person p : guests) {
			System.out.println( "\t" +  p  );
		}
		
	
	}

}
