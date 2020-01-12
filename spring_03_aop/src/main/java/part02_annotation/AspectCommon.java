package part02_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//공통로직만 구현해놓은 클래스-공통관점
@Aspect
public class AspectCommon {
	public AspectCommon() {
		
	}
	
	@Before("execution(* part02_annotation.ServiceImp.prn1(..))")
	public void comm1() {
		System.out.println("-[Advice]before");
	}
	
	@After("execution(* part02_annotation.ServiceImp.prn2(..))")
	public void comm2() {
		System.out.println("-[Advice]after");
	}
	
	@AfterReturning(value="execution(* part02_annotation.ServiceImp.prn3(..))", returning="name")
	public void comm3(String name) {
		System.out.println("-[Advice]after-returnning : "+name);
	}
	
	@AfterThrowing(value="execution(* part02_annotation.ServiceImp.prn4(..))", throwing="ex")
	public void comm4(Exception ex) {
		System.out.println("-[Advice]after-throwing :"+ex.toString());	
	}
	
	@Around(value="execution(* part02_annotation.ServiceImp.prn5(..))")
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
