package part01_xml;

//핵심 로직만 구현해놓은 클래스 - 핵심관점
public class ServiceImp implements Service{
	public ServiceImp() {
		System.out.println("ServiceImp기본생성자");
	}
	
	@Override
	public void prn1() {
		System.out.println("[Start]prn1");
		
		System.out.println("[End]prn1");
	}

	@Override
	public void prn1(int x) {
		System.out.println("[Start]prn1");
		System.out.println("x:" + x);
		System.out.println("[End]prn1");
		
	}

	@Override
	public void prn1(int a, int b) {
		System.out.println("[Start]prn1");
		System.out.printf("prn: a=%d, b=%d\n", a, b);
		System.out.println("[End]prn1");
	}

	@Override
	public void prn2() {
		System.out.println("[Start]prn2");
		
		System.out.println("[End]prn2");
		
	}

	@Override
	public String prn3() {
		System.out.println("[Start]prn3");
		
		System.out.println("[End]prn3");
		return "홍길동";
	}

	@Override
	public void prn4() {
		System.out.println("[Start]prn4");
		String data = "aaaaaaaa";
		int num = Integer.parseInt("data"); //Exception발생시키기
		System.out.println("[End]prn4");
		
	}

	@Override
	public void prn5() {
		System.out.println("[Start]prn5");
		
		System.out.println("[End]prn5");
		
	}

}
