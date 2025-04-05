package org.shark.have_to_be_generated;

import feign.Headers;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-19T17:43:23.988612+03:00[Europe/Moscow]", comments = "Generator version: 7.11.0")
public interface RandomSubModuleControllerApi extends ApiClient.Api {
	
	/** Сервис получения инфы об имени пользователя в СУБД
	 *
	 * @param requestContainer requestContainer (required)
	 * @return ResponseGetInfoResult
	 */
	@RequestLine("POST /api/get_info")
	@Headers({
		"Content-Type: application/json",
		"Accept: */*",
	})
	ResponseContainerGetInfoResponse getInfoUsingPOST(RequestContainerGetInfoRequest requestContainer);
}
