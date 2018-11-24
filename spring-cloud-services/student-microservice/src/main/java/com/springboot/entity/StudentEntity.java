package com.springboot.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("student")
public class StudentEntity implements Serializable {

	/*
	 * create table student( id text, first_name text, last_name text, age int,
	 * major text, time_stamp timestamp, PRIMARY KEY ((id, last_name), time_stamp))
	 * with clustering order by (time_stamp desc); create type
	 * address_type(address_id text, houseNumber text, street text, city text, state
	 * text, zipCode text); alter table student add address frozen<address_type>;
	 * select * from student;
	 */

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private StudentPrimaryKey primaryKey;

	@Column("first_name")
	private String firstName;

	@Column("age")
	private String age;

	@Column("address")
	private AddressEntity address;

	@Column("major")
	private String major;

	@Column("transaction_date")
	private Date timeStamp;

	@Column("unique_id")
	private UUID uniqueId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public StudentPrimaryKey getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(StudentPrimaryKey primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public UUID getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(UUID uniqueId) {
		this.uniqueId = uniqueId;
	}
}