package org.shark.have_to_be_generated;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Types;
import feign.jackson.JacksonDecoder;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class ApiResponseDecoder extends JacksonDecoder {
	
	public ApiResponseDecoder(ObjectMapper mapper) {
		super(mapper);
	}
	
	@Override
	public Object decode(Response response, Type type) throws IOException {
		if (type instanceof ParameterizedType && Types.getRawType(type).isAssignableFrom(
				ApiResponse.class)) {
			Type responseBody = ((ParameterizedType) type).getActualTypeArguments()[0];
			Object body = super.decode(response, responseBody);
			Map<String, Collection<String>> responseHeaders = Collections.unmodifiableMap(response.headers());
			return new ApiResponse<>(response.status(), responseHeaders, body);
		} else {
			return super.decode(response, type);
		}
	}
}
