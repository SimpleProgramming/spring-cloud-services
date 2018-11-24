package com.springboot.entity;

import java.io.Serializable;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

public class RequestCapturePrimaryKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	@Column("id")
	private String id;

	@PrimaryKeyColumn(name = "last_name", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	@Column("last_name")
	private String lastName;

	@PrimaryKeyColumn(name = "verify_value", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	@Column("verify_value")
	private String verify_value;

	public String getVerify_value() {
		return verify_value;
	}

	public void setVerify_value(String verify_value) {
		this.verify_value = verify_value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
