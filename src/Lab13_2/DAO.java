package Lab13_2;

import java.util.List;
import java.util.Optional;

public interface DAO <T>{
	
	Optional<T> findbyID(long id);
	List<T> FINDALL();
	
	void save( T t);
	
	void update( T t,String params);
	
	void delete(T t);
	
}