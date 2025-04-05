package org.shark.dictionary;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResponseCode {
	OK(200, ""),
	BAD_REQUEST(400, "Поле %s обязательно к заполнению"),
	USER_NOT_FOUND(404, "Пользователь %s не найден");
	
	@Getter
	private final int code;
	@Getter
	private final String message;
}
