package part02_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
    	
    	System.out.println("[Start]컨테이너 생성");
    	ApplicationContext context = new ClassPathXmlApplicationContext("part02_annotation/aop.xml");
    	System.out.println("[End]컨테이너 생성\n");
    	
    	Service svc=(Service)context.getBean("svc");
    	
    	svc.prn1();
    	System.out.println("");
    	svc.prn1(10);
    	System.out.println("");
    	svc.prn1(20,30);
    	System.out.println("");
    	
    	svc.prn2();
    	System.out.println("");
    	
    	svc.prn3();
    	System.out.println("");
    	
    	try {
    		svc.prn4();
    	}catch(Exception ex) {    	}
    	System.out.println("");
    	
    	svc.prn5();
    	System.out.println("");
    	
    }//end main
}//end class
