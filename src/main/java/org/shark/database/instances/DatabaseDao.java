package org.shark.database.instances;

import lombok.experimental.UtilityClass;
import org.shark.configuration.BaseConfig;

@UtilityClass
public class DatabaseDao {
	
	private static TemporaryDatabaseDao databaseDb;
	
	public TemporaryDatabaseDao getInstance() {
		initializeTestDao();
		return databaseDb;
	}
	
	public synchronized void initializeTestDao() {
		if (databaseDb == null) {
			var dbConfig = new BaseConfig("jdbc:oracle:thin:[shark/shark]@localhost[:5432]:test_db",
					"shark", "shark");
			databaseDb = new TemporaryDatabaseDao(dbConfig.getUser(), dbConfig.getPassword(), dbConfig.getUrl());
		}
	}
}
