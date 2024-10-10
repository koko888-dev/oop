package Lab13_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Lab13_1.Item;

public class ItemDAO implements DAO<Item>{
	File f = new File("sell.txt");

	@Override
	public Optional<Item> findbyID(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Item> FINDALL() {
		// TODO Auto-generated method stub
		List<Item> shop = new ArrayList<Item>();
		Reader reader = null;
		try {
			reader = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader buff = new BufferedReader(reader);
		//ArrayList<Item> shop  = new ArrayList<Item> ();
		
		String data;
		//String datas[]=null;
		try {
			while((data = buff.readLine())!=null) {
				String datas[] = data.split(",");
				shop.add(new Item(datas[0], Double.valueOf(datas[1]), Integer.valueOf(datas[2])));
				//for (String d : datas) {
			        //System.out.println(d);
			    //}
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			buff.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shop;
	}

	@Override
	public void save(Item t) {
		
		
	}

	@Override
	public void update(Item t, String params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Item t) {
		// TODO Auto-generated method stub
		
	}

}
