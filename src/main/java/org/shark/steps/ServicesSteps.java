package org.shark.steps;

import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;
import org.shark.controller.ProjectController;
import org.shark.have_to_be_generated.RequestContainerGetInfoRequest;
import org.shark.have_to_be_generated.ResponseContainerGetInfoResponse;
import org.shark.model.ObjectEntity;

@UtilityClass
public class ServicesSteps {
	
	@Step("Вызываем сервис get_info")
	public static ResponseContainerGetInfoResponse getInfo(ObjectEntity object) {
		var request = new RequestContainerGetInfoRequest()
				              .id(String.valueOf(object.getId()))
				              .name(object.getName());
		return ProjectController.getRandomSubModuleControllerApi()
				       .getInfoUsingPOST(request);
	}

}
