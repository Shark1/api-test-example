package org.shark.have_to_be_generated;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import feign.Feign;
import feign.RequestInterceptor;
import feign.form.FormEncoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.openapitools.jackson.nullable.JsonNullableModule;

@Setter
@Getter
@AllArgsConstructor
public class ApiClient {
	public interface Api {}
	
	protected ObjectMapper objectMapper;
	private String basePath = "https://example/swagger/link";
	private Map<String, RequestInterceptor> apiAuth;
	private Feign.Builder feignBuilder;
	
	public ApiClient() {
		apiAuth = new LinkedHashMap<String, RequestInterceptor>();
		objectMapper = createObjectMapper();
		feignBuilder = Feign.builder()
				               .client(new OkHttpClient())
				               .encoder(new FormEncoder(new JacksonEncoder(objectMapper)))
				               .decoder(new ApiResponseDecoder(objectMapper));
	}
	
	private ObjectMapper createObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
		objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
		JsonNullableModule jnm = new JsonNullableModule();
		objectMapper.registerModule(jnm);
		return objectMapper;
	}
	
	public <T extends Api> T buildClient(Class<T> clientClass) {
		return feignBuilder.target(clientClass, basePath);
	}
	
	public String selectHeaderContentType(String contentTypes) {
		if (StringUtils.containsIgnoreCase(contentTypes, "application/json")) return "application/json";
		return contentTypes;
	}
	
	/**
	 * Helper method to configure the bearer token.
	 * @param bearerToken the bearer token.
	 */
	public void setBearerToken(String bearerToken) {
		HttpBearerAuth apiAuthorization =  getAuthorization(HttpBearerAuth.class);
		apiAuthorization.setBearerToken(bearerToken);
	}
	
	/**
	 * Helper method to configure the supplier of bearer tokens.
	 * @param tokenSupplier the supplier of bearer tokens.
	 */
	public void setBearerToken(Supplier<String> tokenSupplier) {
		HttpBearerAuth apiAuthorization =  getAuthorization(HttpBearerAuth.class);
		apiAuthorization.setBearerToken(tokenSupplier);
	}
	
	/**
	 * Helper method to configure the first api key found
	 * @param apiKey API key
	 */
	public void setApiKey(String apiKey) {
		ApiKeyAuth apiAuthorization =  getAuthorization(ApiKeyAuth.class);
		apiAuthorization.setApiKey(apiKey);
	}
	
	/**
	 * Helper method to configure the username/password for basic auth
	 * @param username Username
	 * @param password Password
	 */
	public void setCredentials(String username, String password) {
		HttpBasicAuth apiAuthorization = getAuthorization(HttpBasicAuth.class);
		apiAuthorization.setCredentials(username, password);
	}
	
	/**
	 * Gets request interceptor based on authentication name
	 * @param authName Authentication name
	 * @return Request Interceptor
	 */
	public RequestInterceptor getAuthorization(String authName) {
		return apiAuth.get(authName);
	}
	
	/**
	 * Adds an authorization to be used by the client
	 * @param authName Authentication name
	 * @param authorization Request interceptor
	 */
	public void addAuthorization(String authName, RequestInterceptor authorization) {
		if (apiAuth.containsKey(authName)) {
			throw new RuntimeException("auth name \"" + authName + "\" already in api authorizations");
		}
		apiAuth.put(authName, authorization);
		feignBuilder.requestInterceptor(authorization);
	}
	
	private <T extends RequestInterceptor> T getAuthorization(Class<T> type) {
		return (T) apiAuth.values()
				           .stream()
				           .filter(requestInterceptor -> type.isAssignableFrom(requestInterceptor.getClass()))
				           .findFirst()
				           .orElseThrow(() -> new RuntimeException("No Oauth authentication or OAuth configured!"));
	}
	
}
