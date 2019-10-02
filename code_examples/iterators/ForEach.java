package code_examples.iterators;

import java.util.ArrayList; 

public class ForEach { 
  public static void main (String [] args ) {
    ArrayList<String> list = new ArrayList<String>();
    
    list.add("Warsaw"); 
    list.add("Venice");
    list.add("Atlanta");
    list.add("New York");
    list.add("Rome");
    
    for ( String city : list ) 
      System.out.println(city); 
      
    //add duplicates 
    for (String city : list )
      list.add(city); 
      
    //remove cities starting with "W" 
    for ( String city : list ) 
      if ( city.startsWith("W") ) 
        list.remove (city) ;
  }
}
