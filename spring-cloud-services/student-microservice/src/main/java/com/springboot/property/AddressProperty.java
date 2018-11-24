package com.springboot.property;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "address")
public class AddressProperty extends BaseProperty implements Serializable {
	private static final long serialVersionUID = 1L;
}