package org.shark.steps;

import io.qameta.allure.Step;
import javax.annotation.Nullable;
import lombok.experimental.UtilityClass;
import org.shark.model.ObjectEntity;

@UtilityClass
public class CommonSteps {
	
	@Step("Создаём сущность")
	public ObjectEntity createObject(@Nullable Integer id, String name) {
		return ObjectEntity.builder()
				       .id(id)
				       .name(name)
				       .build();
	}
}
