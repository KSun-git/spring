package part02_daoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class MemDaoImp extends JdbcDaoSupport implements MemDAO{
	
	public MemDaoImp() {}
	
	@Override
	public List<MemDTO> list() {
		String sql="select * from mem order by num desc";
		List<MemDTO> mList = getJdbcTemplate().query(sql, new RowMapper<MemDTO>() {
			@Override
			public MemDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				return dto;
			}
		});
		
		return mList;
	}

	@Override
	public void insertMethod(MemDTO dto) {
		String sql = "insert into mem values(mem_num_seq.nextval, ?, ?, ?)";
	      Object[] args = new Object[] {dto.getName(), dto.getAge(), dto.getLoc()};
	      getJdbcTemplate().update(sql, args);		
	}

	@Override
	public MemDTO updateMethod(int num) {
		
		return null;
	}

	@Override
	public void updateMethod(MemDTO dto) {
		 String sql = "update mem set name=? where num=?";
	      Object[] args = new Object[] {dto.getName(), dto.getNum()};
	      getJdbcTemplate().update(sql, args);

		
	}

	@Override
	public void deleteMethod(int num) {
		String sql="delete from mem where num=?";
		Object[] args = new Object[] {num};
		getJdbcTemplate().update(sql, args);		
	}

	@Override
	public MemDTO one(int num) {
		String sql="select * from mem where num=?";
		Object[] args = new Object[] {num};
		MemDTO one = getJdbcTemplate().queryForObject(sql, args, new RowMapper<MemDTO>() {
			@Override
			public MemDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				return dto;
			}
			
		});
		return one;
	}

	@Override
	public int countMethod() {
		String sql = "select count(*) from mem";
		int count = getJdbcTemplate().queryForObject(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
				return rs.getInt(1);
			}
			
		});
		return count;
	}
	
}
