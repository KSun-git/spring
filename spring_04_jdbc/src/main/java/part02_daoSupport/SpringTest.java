package part02_daoSupport;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		
		System.out.println("[Start]컨테이너 생성");
		ApplicationContext context = new ClassPathXmlApplicationContext("part02_daoSupport/jdbc.xml");
		System.out.println("[End]컨테이너 생성\n");
		
		MemDAO dao=(MemDAO)context.getBean("dao");
		
		//[1]Insert
		//System.out.printf("[Insert]");
		//dao.insertMethod(new MemDTO("박나래", 40, "서울"));
		//System.out.println("");
		
		//[2]Update????????????????????
		//System.out.printf("[Update]");
		//dao.updateMethod(new MemDTO(1,"박나리"));
		//System.out.println("");
		
		//[3]Delete
		//dao.deleteMethod(1);
		//System.out.println("");
		
		
		//[4]Num으로 레코드 출력
		System.out.println("[one(2)]");
		MemDTO dto = dao.one(2);
		System.out.printf("%d \t|%s \t|%d \t|%s \n", dto.getNum(), dto.getName(),
                                                                         dto.getAge(), dto.getLoc());
		System.out.println("");
		
		
		//[5]모든 레코드의 갯수
		System.out.println("[countMethod()]");
		int count = dao.countMethod();
		System.out.println("레코드의 갯수 : "+ count);
		System.out.println("");
		
		
		//[6]모든 레코드 출력
		System.out.println("[list()]");
		List<MemDTO> mList = dao.list();
		for(MemDTO mdto : mList) {
			System.out.printf("%d \t|%s \t|%d \t|%s \n", mdto.getNum(), mdto.getName(),
					                                                         mdto.getAge(), mdto.getLoc()); 
		}
		System.out.println("");

	}

}
