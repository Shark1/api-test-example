package org.shark.client;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import feign.Retryer;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.shark.have_to_be_generated.ApiClient;
import org.shark.interceptors.GenerateTraceIdInterceptor;
import org.shark.interceptors.UserInfoInterceptor;
import org.shark.configuration.BaseConfig;

public class ProjectClient extends ApiClient {

	private static final BaseConfig CONFIG = new BaseConfig("https://example/swagger/link", "shark", "shark");
	
	public ProjectClient() {
		this(CONFIG.getUrl(), Base64.getEncoder()
				                      .encodeToString("%s:%s".formatted(CONFIG.getUser(),
						                      CONFIG.getPassword()).getBytes(
													  StandardCharsets.UTF_8)));
	}
	
	public ProjectClient(String url, String creds) {
		super.setBasePath(url);
		super.getFeignBuilder()
				.requestInterceptor(new UserInfoInterceptor())
				.requestInterceptor(new GenerateTraceIdInterceptor())
				.requestInterceptor((requestTemplate) ->
					requestTemplate.header("Content-Type", new String[] {"application/json"}))
				.requestInterceptor((requestTemplate) -> requestTemplate.header("Authorization",
						new String[] {"Basic %s".formatted(creds)}))
				.retryer(Retryer.NEVER_RETRY);
		
		getObjectMapper().setSerializationInclusion(Include.USE_DEFAULTS);
		getObjectMapper().setSerializationInclusion(Include.NON_NULL);
	}
}
