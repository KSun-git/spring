package part02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	public static void main(String[] args) {
		
		System.out.println("[Start]컨테이너 생성");
		ApplicationContext context = new ClassPathXmlApplicationContext("part02/tx.xml");
		System.out.println("[End]컨테이너 생성\n");
		
		System.out.println("[insertProcess()]");
		Service svc = (Service)context.getBean("svc");
		try {
			svc.insertProcess();
			System.out.println("[insertProcess() : commit!]");
		}catch(Exception e) {
			System.out.println(e.toString()+"[insertProcess() : rollback!]");
		}
		System.out.println("");
	}
}
