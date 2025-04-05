package org.shark.database.instances;

public interface BaseDao {
	
	<T> T queryForObject(String sql, Class<T> clazz, Object... args);
	
	/**
	 * Issue a single SQL update operation (such as an insert, update or delete statement)
	 * via a prepared statement, binding the given arguments.
	 */
	int update(final String sql, Object... args);
	
}

