package part01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	public static void main(String[] args) {
		
		System.out.println("[Start]컨테이너 생성");
		ApplicationContext context = new ClassPathXmlApplicationContext("part01/tx.xml");
		System.out.println("[End]컨테이너 생성\n");
		
		System.out.println("[insertProcess()]");
		Service svc = (Service)context.getBean("svc");
		svc.insertProcess();
		System.out.println("");
	}
}
