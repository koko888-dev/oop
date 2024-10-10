package Lab12_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetMath {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String value = scanner.nextLine();

		value = value.replaceAll(" ", "");
		value = value.replace("[", "").replace("]", "");
		String[] sp = null;
		if(value.contains("+")) sp= value.split("\\+");
		else if(value.contains("-")) sp= value.split("\\-");
		else if(value.contains("*")) sp= value.split("\\*");


        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

            String[] digitA = sp[0].split(",");
            for (String A : digitA) {
                setA.add(Integer.parseInt(A));
            }

            String[] digitB = sp[1].split(",");
            for (String B : digitB) {
                setB.add(Integer.parseInt(B));
            }
  
    
     

	// To find union
    if(value.contains("+")) {
	Set<Integer> union = new HashSet<Integer>(setA);
	union.addAll(setB);
	System.out.print("Union of the two Set");
	System.out.println(union);
    }
	// To find intersection
    if(value.contains("*")) {
	Set<Integer> intersection = new HashSet<Integer>(setA);
	intersection.retainAll(setB);
	System.out.print("Intersection of the two Set");
	System.out.println(intersection);
    }
	// To find the symmetric difference
    if(value.contains("-")) {
	Set<Integer> difference = new HashSet<Integer>(setA);
	difference.removeAll(setB);
	System.out.print("Difference of the two Set");
	System.out.println(difference);
	}
  }

}
