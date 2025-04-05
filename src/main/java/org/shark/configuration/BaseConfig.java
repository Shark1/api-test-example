package org.shark.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseConfig {
	
	String url;
	String user;
	String password;
	
}
