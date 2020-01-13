package part03_template;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		
		System.out.println("[Start]컨테이너 생성");
		ApplicationContext context = new ClassPathXmlApplicationContext("part03_template/jdbc.xml");
		System.out.println("[End]컨테이너 생성\n");
		
		MemDAO dao=(MemDAO)context.getBean("dao");
		
		/*[1]Insert*/
		//System.out.printf("[Insert]");
		//dao.insertMethod(new MemDTO("스티븐", 50, "부산"));
		//System.out.println("");
		
		/*[2]Update*/
		//System.out.printf("[Update]");
		//dao.updateMethod(new MemDTO(9, "김자바"));
		//System.out.println("");
		
		/*[3]Delete*/
		//dao.deleteMethod(8);
		//System.out.println("");
		
		
		/*[4]Num으로 레코드 출력*/
		System.out.println("[one(2)]");
		MemDTO dto = dao.one(2);
		if(dto!=null) {
			System.out.printf("%d \t|%s \t|%d \t|%s \n", dto.getNum(), dto.getName(),
	                                                                         dto.getAge(), dto.getLoc());
			System.out.println("");
		}else {
			System.out.println("해당레코드없음\n");
		}
		
		
		/*[5]모든 레코드의 갯수*/
		System.out.println("[countMethod()]");
		int count = dao.countMethod();
		System.out.println("레코드의 갯수 : "+ count);
		System.out.println("");
		
		
		/*[6]모든 레코드 출력*/
		System.out.println("[list()]");
		List<MemDTO> mList = dao.list();
		for(MemDTO mdto : mList) {
			System.out.printf("%d \t|%s \t|%d \t|%s \n", mdto.getNum(), mdto.getName(),
					                                                         mdto.getAge(), mdto.getLoc()); 
		}
		System.out.println("");
		
		
		/*[7-1]조건부 레코드 출력*/
		System.out.println("[searchMethod(6)]");
		List<MemDTO> sList = dao.searchMethod(6);
		if(sList.isEmpty()) {
			System.out.println("해당레코드없음\n");
		}else {
			for(MemDTO mdto : sList) {
				System.out.printf("%d \t|%s \t|%d \t|%s \n", mdto.getNum(), mdto.getName(),
						                                                         mdto.getAge(), mdto.getLoc()); }
			System.out.println("");
		}
		
		/*[7-2]조건부 레코드 출력*/
		System.out.println("[searchMethod(HashMap)]");
		HashMap<String, Integer> map =new HashMap<String, Integer>();
		map.put("start", 1);   
		map.put("end", 3); 
		List<MemDTO> aList = dao.searchMethod(map);
		if(sList.isEmpty()) {
			System.out.println("해당레코드없음\n");
		}else {
			for(MemDTO mdto : aList) {
				System.out.printf("%d \t|%s \t|%d \t|%s \n", mdto.getNum(), mdto.getName(),
						                                                         mdto.getAge(), mdto.getLoc()); }
			System.out.println("");
		}
	}

}
