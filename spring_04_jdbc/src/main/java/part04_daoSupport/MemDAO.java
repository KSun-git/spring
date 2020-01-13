package part04_daoSupport;

import java.util.HashMap;
import java.util.List;

public interface MemDAO {
	public List<MemDTO> list();
	
	public void insertMethod(MemDTO dto);
	
	public MemDTO updateMethod(int num);
	
	public void updateMethod(MemDTO dto);
	
	public void deleteMethod(int num);
	
	public MemDTO one(int num);
	
	public int countMethod();
	
	public List<MemDTO> searchMethod(int num);
	
	public List<MemDTO> searchMethod(HashMap<String, Integer> map);
	
}
