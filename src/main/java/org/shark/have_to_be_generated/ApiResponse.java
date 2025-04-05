package org.shark.have_to_be_generated;

import java.util.Collection;
import java.util.Map;

public class ApiResponse<T> {
	
	final private int statusCode;
	final private Map<String, Collection<String>> headers;
	final private T data;
	
	public ApiResponse(int statusCode, Map<String, Collection<String>> headers) {
		this(statusCode, headers, null);
	}
	
	public ApiResponse(int statusCode, Map<String, Collection<String>> headers, T data) {
		this.statusCode = statusCode;
		this.headers = headers;
		this.data = data;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public Map<String, Collection<String>> getHeaders() {
		return headers;
	}
	
	public T getData() {
		return data;
	}
}
