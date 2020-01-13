package part05_emp;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import part03_template.MemDTO;

public class SpringTest {

	public static void main(String[] args) {
		/*
		 * Employees테이블에서 salary이  높은 5-10랭크에 해당하는
		 * employee_id, first_name, salary, hire_date을
		 * 출력하시오.
		 */
		
		System.out.println("[Start]컨테이너 생성");
		ApplicationContext context= new ClassPathXmlApplicationContext("part05_emp/jdbc.xml");
		System.out.println("[End]컨테이너 생성\n");
		EmpDAO dao=(EmpDAO)context.getBean("dao");		
		
		/*순위 조건 검색*/
		System.out.println("[searchMethod]");
		HashMap<String, Integer> map =new HashMap<String, Integer>();
		map.put("start", 5);
		map.put("end", 10); 
		List<EmpDTO> aList = dao.searchMethod(map);
		if(aList.isEmpty()) {
			System.out.println("해당레코드없음\n");
		}else {
			for(EmpDTO mdto : aList) {
				System.out.printf("(%s, %s, %d, %tY년/%tm월/%td일) \n", mdto.getEmployee_id(), 
						                                                                               mdto.getFirst_name(),
						                                                                               mdto.getSalary(),
						                                                                               mdto.getHire_date(), 
						                                                                               mdto.getHire_date(), 
						                                                                               mdto.getHire_date()); }
			System.out.println("");
		}

	}//end main( )

}//end class
