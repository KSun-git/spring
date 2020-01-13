package part03_template;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
/*
 * Template 클래스
 * 1.개발자가 중복된 코드를 입력해야 하는 작업을 줄일 수 있도록 돕고있다.
 * 2.JDBC뿐만 아니라 myBatis, JMS와 같은 다양한 기술에 대해 템플릿을 제공한다.
 * 3.예로 Jdbc인 경우 JdbcTemplate클래스를 제공하고 있으며, JdbcTemplate클래스를
 *    사용함으로써 try~catch~finally 및 커넥션 관리를 위한 중복된 코드를 줄이거나, 없앨 수 있다.
 *    
 *    									|Java JDBC			|Spring JDBC	|myBatis
 *    select							|executeQuery()		|query()		|selectList()
 *    insert, update, delete	        |executeUpdate()	|update()		|insert(), update(), delete()
 */
public class MemDaoImp implements MemDAO{
	private SqlSessionTemplate sqlSession;
	
	public MemDaoImp() {}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession=sqlSession;
	}

	@Override
	public List<MemDTO> list() {
		return sqlSession.selectList("mem.all");    //("namespace.id")형식으로 사용합니다.
	}

	@Override
	public void insertMethod(MemDTO dto) {
		sqlSession.insert("mem.ins", dto);
		
	}

	@Override
	public MemDTO updateMethod(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMethod(MemDTO dto) {
		sqlSession.update("mem.upt", dto);
		
	}

	@Override
	public void deleteMethod(int num) {
		sqlSession.delete("mem.del", num);
		
	}

	@Override
	public MemDTO one(int num) {
		return sqlSession.selectOne("mem.one", num);
	}

	@Override
	public int countMethod() {
		return sqlSession.selectOne("mem.cnt");
	}

	@Override
	public List<MemDTO> searchMethod(int num) {
		return sqlSession.selectList("mem.search", num);
	}

	@Override
	public List<MemDTO> searchMethod(HashMap<String, Integer> map) {
		return sqlSession.selectList("mem.range", map);
	}

	
	
	
}
