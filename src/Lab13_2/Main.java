package Lab13_2;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import Lab13_1.Item;

import java.io.BufferedReader;

public class Main {
	
	public static void main(String[] args) throws IOException {

		
		ItemDAO itemDAO = new ItemDAO();
		itemDAO.FINDALL();
		
		System.out.println("Final shopping cart totals");
		float sum=0;
		for(Item s : itemDAO.FINDALL()) {
			System.out.print(s);
			System.out.printf("%.2f\n" ,s.getQuantity()*s.getPrice());
			sum+=(float) (s.getQuantity()*s.getPrice());
			
		}
		System.out.printf("totals $ amount in cart : %.2f",sum);

		
		
	}
	


}
