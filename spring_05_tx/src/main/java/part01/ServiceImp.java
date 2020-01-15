package part01;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class ServiceImp implements Service{
	private MemDAO dao;
	private TransactionTemplate transactionTemplate;  
	
	public ServiceImp() {}
	
	public void setDao(MemDAO dao) {
		this.dao = dao;
	}
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public void insertProcess() {
		//num값이 같으면 오류납니다. -> 차례대로 진행되면 먼저 실행된 레코드만 정상적으로 테이블에 삽입됩니다.
		//dao.insertMethod(new MemDTO(10, "용팔이", 50, "경기"));
		//dao.insertMethod(new MemDTO(10, "유대위", 30, "대전"));
		
		
		//트랜잭션처리로, 작업단위에서 Exception발생 시 단위의 처음으로 롤백! 두 레코드 모두 삽입안됩니다.
		Object result = transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				try {
					dao.insertMethod(new MemDTO(10, "용팔이", 45, "경기"));
					dao.insertMethod(new MemDTO(10, "유대위", 33, "강원도"));
					return "ok";
				}catch(Exception e){
					status.setRollbackOnly();
					return e.toString();
				}
			}
		});
		
		System.out.println("result:"+result);
	}

}
