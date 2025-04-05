package org.shark.have_to_be_generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({
		RequestContainerGetInfoRequest.JSON_PROPERTY_TRACE_ID,
		RequestContainerGetInfoRequest.JSON_PROPERTY_USER_INFO,
		RequestContainerGetInfoRequest.JSON_PROPERTY_ID,
		RequestContainerGetInfoRequest.JSON_PROPERTY_NAME
})
public class RequestContainerGetInfoRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String JSON_PROPERTY_TRACE_ID = "trace_id";
	@javax.annotation.Nonnull
	private String traceId;
	
	public static final String JSON_PROPERTY_USER_INFO = "user_info";
	@javax.annotation.Nonnull
	private String userInfo;
	
	public static final String JSON_PROPERTY_ID = "id";
	@javax.annotation.Nonnull
	private String id;
	
	public static final String JSON_PROPERTY_NAME = "name";
	@javax.annotation.Nonnull
	private String name;
	
	public RequestContainerGetInfoRequest() {
	}
	
	public RequestContainerGetInfoRequest traceId(@javax.annotation.Nonnull String traceId) {
		
		this.traceId = traceId;
		return this;
	}
	
	/**
	 * Идентификатор запроса
	 * @return traceId
	 */
	@javax.annotation.Nonnull
	@JsonProperty(JSON_PROPERTY_TRACE_ID)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	
	public String getTraceId() {
		return traceId;
	}
	
	
	@JsonProperty(JSON_PROPERTY_TRACE_ID)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	public void setTraceId(@javax.annotation.Nonnull String traceId) {
		this.traceId = traceId;
	}
	
	
	public RequestContainerGetInfoRequest userInfo(@javax.annotation.Nonnull String userInfo) {
		
		this.userInfo = userInfo;
		return this;
	}
	
	/**
	 * Информация о пользователе
	 * @return userInfo
	 */
	@javax.annotation.Nonnull
	@JsonProperty(JSON_PROPERTY_USER_INFO)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	
	public String getUserInfo() {
		return userInfo;
	}
	
	
	@JsonProperty(JSON_PROPERTY_USER_INFO)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	public void setUserInfo(@javax.annotation.Nonnull String userInfo) {
		this.userInfo = userInfo;
	}
	
	
	public RequestContainerGetInfoRequest id(@javax.annotation.Nonnull String id) {
		
		this.id = id;
		return this;
	}
	
	/**
	 * Номер
	 * @return id
	 */
	@javax.annotation.Nonnull
	@JsonProperty(JSON_PROPERTY_ID)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	
	public String getId() {
		return id;
	}
	
	
	@JsonProperty(JSON_PROPERTY_TRACE_ID)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	public void setAccountNumber(@javax.annotation.Nonnull String id) {
		this.id = id;
	}
	
	public RequestContainerGetInfoRequest name(@javax.annotation.Nonnull String name) {
		
		this.id = name;
		return this;
	}
	
	/**
	 * Номер
	 * @return id
	 */
	@javax.annotation.Nonnull
	@JsonProperty(JSON_PROPERTY_NAME)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	
	public String getName() {
		return name;
	}
	
	
	@JsonProperty(JSON_PROPERTY_TRACE_ID)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	public void setName(@javax.annotation.Nonnull String name) {
		this.name = name;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RequestContainerGetInfoRequest requestContainerGetStmtInfoRequest = (RequestContainerGetInfoRequest) o;
		return Objects.equals(this.traceId, requestContainerGetStmtInfoRequest.traceId) &&
				       Objects.equals(this.userInfo, requestContainerGetStmtInfoRequest.userInfo) &&
				       Objects.equals(this.id, requestContainerGetStmtInfoRequest.id) &&
				       Objects.equals(this.name, requestContainerGetStmtInfoRequest.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(traceId, userInfo, id);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RequestContainerGetStmtInfoRequest {\n");
		sb.append("    traceId: ").append(toIndentedString(traceId)).append("\n");
		sb.append("    userInfo: ").append(toIndentedString(userInfo)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("}");
		return sb.toString();
	}
	
	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	
}
