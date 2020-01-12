package part01_xml;

import org.aspectj.lang.ProceedingJoinPoint;
//공통로직만 구현해놓은 클래스-공통관점
public class AspectCommon {
	public AspectCommon() {
		
	}
	
	public void comm1() {
		System.out.println("-[Advice]before");
	}
	
	public void comm2() {
		System.out.println("-[Advice]after");
	}
	
	public void comm3(String name) {
		System.out.println("-[Advice]after-returnning : "+name);
	}
	
	public void comm4(Exception ex) {
		System.out.println("-[Advice]after-throwing :"+ex.toString());	
	}
	
	public void comm5(ProceedingJoinPoint point) {
		System.out.println("-[Advice]around start");
		try {
			point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("-[Advice]around end");
	}
}
