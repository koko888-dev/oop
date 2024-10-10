package Lab13_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
		return null;
	}

	@Override
	public void save(Item t) {
		
		try  {
			FileWriter fwr = new FileWriter(f, true);
		    fwr.write(t.toString());
			fwr.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
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
