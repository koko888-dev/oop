package Lab8_2;

import java.util.Iterator;

public class Main{

public static void main(String[] args) {
	 // TODO Auto-generated method stub
	 String[] names = {"John","May","Ryan"};
	 Containers c = ()-> {
		 //public Iterator getIterator() {
			 return new Iterator() {
				 
				 int index = 0 ;
				 public boolean hasNext() {
					 if(index < names.length)
					 return true ;
					 return false;
					 }
					 public Object next() {
					 return names[index++];
					 //return null;
					 }

					 public void remove() {

					 }
			 };
	 //}
		
		
	};
	
	for (Iterator iter = c.getIterator(); iter.hasNext();){
		String name = (String) iter.next();
		System.out.println("Name : " + name);
}
	
}
 
}

		

