package Lab12;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
			
		ArrayList<Item> shop  = new ArrayList<Item> ();
		Scanner scanner=new Scanner(System.in);
		String con;

		do {
		System.out.print("Enter the name of the item : ");
		String Aname = scanner.nextLine();
		System.out.print("Enter the unit price : ");
		double Aprice = scanner.nextDouble();
		System.out.print("Enter the quantity : ");
		int Aquantity = scanner.nextInt();
		shop.add(new Item(Aname,Aprice,Aquantity));
		System.out.print("Continue shopping (y/n): ");
		scanner.nextLine();
		con = scanner.nextLine();
		}while(con.equals("y"));
		
		System.out.println("Final shopping cart totals");
		float sum=0;
		for(Item s : shop) {
			System.out.print(s);
			System.out.printf("%.2f\n" ,s.getQuantity()*s.getPrice());
			sum+=(float) (s.getQuantity()*s.getPrice());
			
		}
		System.out.printf("totals $ amount in cart : %.2f",sum);
		
		
		
	}




}
