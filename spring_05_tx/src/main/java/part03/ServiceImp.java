package part03;

import org.springframework.transaction.annotation.Transactional;

public class ServiceImp implements Service{
	private MemDAO dao;

	public ServiceImp() {}
	
	public void setDao(MemDAO dao) {
		this.dao = dao;
	}
	
	@Transactional(rollbackFor=java.lang.Exception.class)
	@Override
	public void insertProcess() {
		dao.insertMethod(new MemDTO(20, "용팔이", 50, "경기"));
		dao.insertMethod(new MemDTO(21, "유대위", 30, "대전"));
	}

}
