package part03_exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
    	
    	System.out.println("[Start]컨테이너 생성");
    	ApplicationContext context = new ClassPathXmlApplicationContext("part03_exam/aop.xml");
    	System.out.println("[End]컨테이너 생성\n");
    	
    	Service svc=(Service)context.getBean("svc");
    	
    	svc.prn();
    	System.out.println("");
    	
    }//end main
}//end class
