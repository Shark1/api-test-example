package get_info;

import static io.qameta.allure.Allure.step;
import static org.shark.dictionary.ResponseCode.OK;

import org.assertj.core.api.SoftAssertions;
import org.shark.database.queries.UserQueries;
import org.shark.model.ObjectEntity;
import org.shark.steps.ServicesSteps;
import org.shark.utils.ValidationModel;
import org.testng.annotations.Test;

public class PositiveTests {
	
	@Test(groups = "smoke_tests", description = "Базовый позитивный тест - изменение имени пользователя")
	public void changingUserNameTest() {
		var id = 1;
		var oldUser = UserQueries.getUserNameById(id);
		
		var newUser = step("Подготавливаем тестовые данные", () -> {
			var changedUser = oldUser.concat("shark");
			
			UserQueries.updateUserNameById(id, changedUser);
			return ObjectEntity.builder()
					       .id(id)
					       .name(changedUser)
					       .build();
		});
		
		var response = ServicesSteps.getInfo(newUser);
		
		step("Выполняем проверки", () -> {
			ValidationModel.parse(response)
							.statusCodeShouldBe(OK)
							.messageShouldBe(OK.getMessage());
			
			var softAssert = new SoftAssertions();
			softAssert.assertThat(response.getUser())
					.as("Полученное имя пользователя не совпадает с изменённым")
					.isEqualTo(newUser.getName());
			
			var expectedUser = UserQueries.getUserNameById(newUser.getId());
			softAssert.assertThat(response.getUser())
					.as("Имя пользователя от сервиса не соответствует имени пользователя в БД")
					.isEqualTo(expectedUser);
			softAssert.assertAll();
			
		});
	}
	
}
