package org.shark.controller;

import lombok.Getter;
import org.shark.client.ProjectClient;
import org.shark.have_to_be_generated.RandomSubModuleControllerApi;

public class ProjectController {
	
	@Getter
	private static final ProjectClient CLIENT = new ProjectClient();
	private static RandomSubModuleControllerApi randomSubModuleControllerApi;
	
	public static RandomSubModuleControllerApi getRandomSubModuleControllerApi() {
		if (randomSubModuleControllerApi == null) {
			randomSubModuleControllerApi = CLIENT.buildClient(RandomSubModuleControllerApi.class);
		}
		return randomSubModuleControllerApi;
	}

}
