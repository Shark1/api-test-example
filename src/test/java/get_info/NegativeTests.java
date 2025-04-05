package get_info;

import static io.qameta.allure.Allure.step;
import static org.shark.dictionary.ResponseCode.BAD_REQUEST;
import static org.shark.dictionary.ResponseCode.USER_NOT_FOUND;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.shark.controller.ProjectController;
import org.shark.have_to_be_generated.RequestContainerGetInfoRequest;
import org.shark.steps.CommonSteps;
import org.shark.steps.ServicesSteps;
import org.shark.utils.ValidationModel;
import org.testng.annotations.Test;

@Owner("shark")
@Epic("project_tests")
@Story("get")
@Feature("get_info")
public class NegativeTests {
	
	@Test(groups = "smoke_tests", description = "Базовый негативный тест - пользователь не найден")
	public void userNotFoundTest() {
		var userNameForTest = "shark";
		var object = step("Подготавливаем тестовые данные",
				() -> CommonSteps.createObject(1, userNameForTest));
		
		var response = ServicesSteps.getInfo(object);
		
		step("Выполняем проверки",
				() -> ValidationModel.parse(response)
						      .statusCodeShouldBe(USER_NOT_FOUND)
						      .messageShouldBe(USER_NOT_FOUND.getMessage()
								                       .formatted(userNameForTest)));
	}
	
	@Test(groups = "smoke_tests", description = "Базовый негативный тест - поле 'name' обязательно")
	public void badRequestByNameFieldTest() {
		var object = step("Подготавливаем тестовые данные",
				() -> CommonSteps.createObject(1, null));
		
		var response = ServicesSteps.getInfo(object);
		
		step("Выполняем проверки",
				() -> ValidationModel.parse(response)
						      .statusCodeShouldBe(BAD_REQUEST)
						      .messageShouldBe(BAD_REQUEST.getMessage()
								                       .formatted("name")));
	}
}
