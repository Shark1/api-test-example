package org.shark.database.queries;

import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;
import org.shark.database.instances.DatabaseDao;

@UtilityClass
public class UserQueries {
	
	@Step("Поиск пользователя по id")
	public String getUserNameById(Integer id) {
		var query = """
				select u.user
				from users u
				where u.id = ?
				""";
		return DatabaseDao
				       .getInstance()
				       .queryForObject(query, String.class, id);
		
	}
	
	@Step("Изменяем имя пользователя по id")
	public void updateUserNameById(Integer id, String newUserName) {
		var query = """
				update users u
				set u.user = ?
				where u.id = ?
				""";
		
		var result = DatabaseDao
				.getInstance()
				.update(query, id, newUserName);
		
		if (result == 0) {
			throw new RuntimeException("Имя пользователя не было изменено!");
		}
	}
}
