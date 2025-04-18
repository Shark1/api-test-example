package org.shark.interceptors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.util.HashMap;
import lombok.SneakyThrows;

public class UserInfoInterceptor implements RequestInterceptor {
	
	@SneakyThrows
	@Override
	public void apply(RequestTemplate template) {
		var mapper = new ObjectMapper();
		var typeReference = new TypeReference<HashMap<String, Object>>() {
		
		};
		HashMap<String, Object> bodyHashMap = mapper.readValue(template.requestBody().asString(), typeReference);
		bodyHashMap.put("user_info", "PLC_AUTOTEST");
		
		var bodyJson = mapper.writeValueAsString(bodyHashMap);
		Request.Body newBody = Request.Body.encoded(bodyJson.getBytes(), template.requestCharset());
		template.body(newBody);
	}
	
}
