package code_examples.list;

public class Person {

	private int age;
	private String name;
	
	
	public Person(String name, int age) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException("null name is not allowed"); 
		}
		if (age < 0 || age > 120 ) {
			throw new IllegalArgumentException("illegal value for age"); 
		}
		this.name = name;
		this.age = age; 
		
	}
	

	@Override
	public boolean equals(Object obj) {
		//check if they are the same object 
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		//
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		
		
		if (age != other.age)
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s (%d)", name, age); 
	}
	
}
