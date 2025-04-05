package org.shark.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrokenTestException extends RuntimeException {
	
	public BrokenTestException(String message) {
		super(message);
	}
}
