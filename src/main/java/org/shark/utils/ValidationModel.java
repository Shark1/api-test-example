package org.shark.utils;

import static io.qameta.allure.Allure.step;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import lombok.SneakyThrows;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.api.Assertions;
import org.shark.dictionary.ResponseCode;
import org.shark.exceptions.BrokenTestException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidationModel {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("trace_id")
	private String traceId;
	
	@JsonProperty("user_info")
	private String userInfo;
	
	@JsonProperty("code")
	private Integer code;
	
	@JsonProperty("message")
	private String message;
	
	@SneakyThrows
	public static <T> ValidationModel parse(T responseModel) {
		var mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		var json = mapper.writeValueAsString(responseModel);
		return mapper.readValue(json, ValidationModel.class);
	}
	
	@SneakyThrows
	public static ValidationModel parse(byte[] responseBody) {
		var mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		
		return mapper.readValue(responseBody, ValidationModel.class);
	}
	
	public ValidationModel statusCodeShouldBe(ResponseCode responseCode) {
		step("Проверяем код ответа для traceId = %s".formatted(this.traceId), () -> {
			step("Ожидаемый код ответа: [%s]".formatted(responseCode.getCode()));
			step("Фактический код ответа: [%s]".formatted(this.code));
			
			if (this.code != null && this.code == responseCode.getCode()) {
				step("Код ответа совпал с ожидаемым");
				Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(Status.PASSED));
				
				Allure.getLifecycle().stopStep();
			} else {
				step("Код ответа не совпадает с ожидаемым", Status.FAILED);
				Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(Status.FAILED));
				
				Assertions.fail("Код ответа не совпал с ожидаемым. Текущий код: [%s] Ожидаемый: [%s]".formatted(
						this.code, responseCode.getCode()));
			}
		});
		
		return this;
	}
	
	public ValidationModel statusCodeShouldBeOrBrokenTest(ResponseCode responseCode) {
		step("Проверяем код ответа для traceId = %s".formatted(this.traceId), () -> {
			if (this.code != null && this.code == responseCode.getCode()) {
				step("Ожидаемый код ответа [%s] и фактический совпадают".formatted(responseCode.getCode()));
				Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(Status.PASSED));
				Allure.getLifecycle().stopStep();
			} else {
				Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(Status.BROKEN));
				throw new BrokenTestException("""
                        Код ответа не совпал с ожидаемым. Ожидаемый: [%s]
                        Текущий код: [%s]
                        Сообщение: "%s"
                        """.formatted(responseCode.getCode(), this.code, this.message));
			}
		});
		
		return this;
	}
	
	public void messageShouldBe(String expectedMessage) {
		step("Проверяем текст сообщения для traceId = %s".formatted(this.traceId), () -> {
			step("Ожидаемый текст сообщения: [%s]".formatted(expectedMessage));
			step("Фактический текст сообщения: [%s]".formatted(this.message));
			
			if (this.message != null && this.message.equalsIgnoreCase(expectedMessage)) {
				step("Текст сообщения совпал с ожидаемым");
				Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(Status.PASSED));
				
				Allure.getLifecycle().stopStep();
			} else {
				step("Текст сообщения не совпадает с ожидаемым", Status.FAILED);
				Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(Status.FAILED));
				
				Assertions.fail("Текст сообщения полностью не совпадает с ожидаемым. "
						                + "Текущее сообщение: [%s] Ожидаемое сообщение: [%s]"
								                  .formatted(this.message, expectedMessage));
			}
		});
	}
	
	
	public ValidationModel messageShouldContains(String expectedMessage) {
		step("Проверяем текст сообщения для traceId = %s".formatted(this.traceId), () -> {
			step("В сообщении ожидается наличие текста [%s]".formatted(expectedMessage));
			step("Фактический текст сообщения: [%s]".formatted(this.message));
			
			if (this.message != null && StringUtils.containsIgnoreCase(this.message, expectedMessage)) {
				step("Текст содержится в исходном тексте сообщения");
				Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(Status.PASSED));
				
				Allure.getLifecycle().stopStep();
			} else {
				step("Текст [%s] не содержится в исходном тексте сообщения".formatted(this.message), Status.FAILED);
				Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(Status.FAILED));
				
				Assertions.fail("Текст сообщения полностью не совпадает с ожидаемым. "
						                + "Текущее сообщение: [%s] Ожидаемое сообщение: [%s]"
								                  .formatted(this.message, expectedMessage));
			}
			Allure.getLifecycle().stopStep();
		});
		
		return this;
	}
	
}

