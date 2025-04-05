package org.shark.have_to_be_generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({
		ResponseContainerGetInfoResponse.JSON_PROPERTY_CODE,
		ResponseContainerGetInfoResponse.JSON_PROPERTY_MESSAGE,
		ResponseContainerGetInfoResponse.JSON_PROPERTY_TRACE_ID,
		ResponseContainerGetInfoResponse.JSON_PROPERTY_USER_INFO
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-19T17:43:23.988612+03:00[Europe/Moscow]", comments = "Generator version: 7.11.0")
public class ResponseContainerGetInfoResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String JSON_PROPERTY_CODE = "code";
	@javax.annotation.Nonnull
	private Integer code;
	
	public static final String JSON_PROPERTY_MESSAGE = "message";
	@javax.annotation.Nullable
	private String message;
	
	public static final String JSON_PROPERTY_TRACE_ID = "trace_id";
	@javax.annotation.Nonnull
	private String traceId;
	
	public static final String JSON_PROPERTY_USER_INFO = "user_info";
	@javax.annotation.Nonnull
	private String userInfo;
	
	public static final String JSON_PROPERTY_USER = "user";
	@javax.annotation.Nonnull
	private String user;
	
	public ResponseContainerGetInfoResponse() {
	}
	
	public ResponseContainerGetInfoResponse code(@javax.annotation.Nonnull Integer code) {
		
		this.code = code;
		return this;
	}
	
	/**
	 * Код результата \\&gt;&#x3D; 0 - Успешный  -1 - -99 - Ошибка выполнения процедуры -100 - Ошибка валидации -101 - Неверный MIME-тип -102 - Неверный request method -200 - Невалидный JSON &lt;&#x3D; -300 - Ошибка бизнес логики приложения
	 * @return code
	 */
	@javax.annotation.Nonnull
	@JsonProperty(JSON_PROPERTY_CODE)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	
	public Integer getCode() {
		return code;
	}
	
	
	@JsonProperty(JSON_PROPERTY_CODE)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	public void setCode(@javax.annotation.Nonnull Integer code) {
		this.code = code;
	}
	
	
	public ResponseContainerGetInfoResponse message(@javax.annotation.Nullable String message) {
		
		this.message = message;
		return this;
	}
	
	/**
	 * Сообщение (обязательно при ошибке, когда code &lt; 0)
	 * @return message
	 */
	@javax.annotation.Nullable
	@JsonProperty(JSON_PROPERTY_MESSAGE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	
	public String getMessage() {
		return message;
	}
	
	
	@JsonProperty(JSON_PROPERTY_MESSAGE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public void setMessage(@javax.annotation.Nullable String message) {
		this.message = message;
	}
	
	
	public ResponseContainerGetInfoResponse traceId(@javax.annotation.Nonnull String traceId) {
		
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
	
	
	public ResponseContainerGetInfoResponse userInfo(@javax.annotation.Nonnull String userInfo) {
		
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
	
	public ResponseContainerGetInfoResponse user(@javax.annotation.Nonnull String user) {
		
		this.user = user;
		return this;
	}
	
	/**
	 * имя пользователя
	 * @return user
	 */
	@javax.annotation.Nonnull
	@JsonProperty(JSON_PROPERTY_USER)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	
	public String getUser() {
		return user;
	}
	
	
	@JsonProperty(JSON_PROPERTY_USER)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	public void setUser(@javax.annotation.Nonnull String user) {
		this.user = user;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResponseContainerGetInfoResponse responseContainerResult = (ResponseContainerGetInfoResponse) o;
		return Objects.equals(this.code, responseContainerResult.code) &&
				       Objects.equals(this.message, responseContainerResult.message) &&
				       Objects.equals(this.traceId, responseContainerResult.traceId) &&
				       Objects.equals(this.userInfo, responseContainerResult.userInfo);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(code, message, traceId, userInfo);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResponseContainerResult {\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    traceId: ").append(toIndentedString(traceId)).append("\n");
		sb.append("    userInfo: ").append(toIndentedString(userInfo)).append("\n");
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
