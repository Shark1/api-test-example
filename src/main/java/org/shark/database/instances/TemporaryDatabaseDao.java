package org.shark.database.instances;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import lombok.Getter;
import org.shark.configuration.BaseConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


public class TemporaryDatabaseDao extends BaseDaoImpl {
	
	private static final BaseConfig CONFIG;
	
	static {
		CONFIG = new BaseConfig("https://example/swagger/link", "shark", "shark");
	}
	
	@Getter
	private final DataSource dataSource;
	
	public TemporaryDatabaseDao(final String login, final String password, final String dbUrl) {
		HikariConfig config = new HikariConfig();
		config.setPoolName("QA_AUTO");
		config.setMaximumPoolSize(120);
		config.setMaxLifetime(TimeUnit.MINUTES.toMillis(180));
		config.setIdleTimeout(60);
		config.setConnectionTimeout(60);
		var initSql = """
                BEGIN execute immediate q'{alter session set NLS_DATE_FORMAT = 'DD-MON-RR'}';
                execute immediate q'{alter session set NLS_DATE_LANGUAGE = 'AMERICAN'}';
                execute immediate q'{alter session set NLS_NUMERIC_CHARACTERS = '.,'}';END;""";
		config.setConnectionInitSql(initSql);
		config.setUsername(login);
		config.setPassword(password);
		String jdbcUrl = dbUrl.contains("jdbc:oracle:thin:@")
				                 ? dbUrl
				                 : "jdbc:oracle:thin:@%s".formatted(dbUrl);
		config.setJdbcUrl(jdbcUrl);
		dataSource = new HikariDataSource(config);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setQueryTimeout(300);
		
		setJdbcOperations(jdbcTemplate);
		
	}
	
}

