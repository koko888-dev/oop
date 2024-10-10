package Lab13_1;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		ItemDAO itemdao = new ItemDAO();
		//File f = new File("sell.txt");
		
		//try {
			//f.createNewFile();
		//} catch (IOException e) {
			//e.printStackTrace();
		//}
		//FileOutputStream fout = new FileOutputStream(f);
		//BufferedWriter bf = new BufferedWriter(new FileWriter(f));
		
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
		
		
		
		Item i = new Item(Aname,Aprice,Aquantity);
        itemdao.save(i);
        
        
        
        shop.add(i); 
		//shop.add(i);
		//byte[] tB = i.getF().getBytes();
		//fout.write(tB);

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


