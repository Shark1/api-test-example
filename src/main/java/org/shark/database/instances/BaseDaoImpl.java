package org.shark.database.instances;

import org.springframework.jdbc.core.JdbcOperations;

public class BaseDaoImpl implements BaseDao {
	private JdbcOperations jdbcOperations;
	
	public BaseDaoImpl() {
	}
	
	public void setJdbcOperations(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}
	
	public <T> T queryForObject(String sql, Class<T> clazz, Object... args) {
		this.operationsCheck();
		return (T)this.jdbcOperations.queryForObject(sql, args, clazz);
	}
	public int update(String sql, Object... args) {
		this.operationsCheck();
		return this.jdbcOperations.update(sql, args);
	}
	
	private void operationsCheck() {
		if (this.jdbcOperations == null) {
			throw new IllegalArgumentException("JdbcOperations is not set. Please, set JdbcOperations first!");
		}
	}
}

