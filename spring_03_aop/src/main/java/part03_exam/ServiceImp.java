package part03_exam;

//핵심 로직만 구현해놓은 클래스 - 핵심관점
public class ServiceImp implements Service{
	public ServiceImp() {
		System.out.println("ServiceImp기본생성자");
	}
	
	@Override
	public void prn() {
		System.out.println("[Start]prn1");
		
		int num=0;
		for(int i=0; i<100000000; i++) {
			num+=i;
		}
		System.out.println("Sum:"+num);
		
		System.out.println("[End]prn1");
	}

}