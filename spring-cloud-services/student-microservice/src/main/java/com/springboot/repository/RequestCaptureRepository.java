package com.springboot.repository;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.entity.AddressEntity;
import com.springboot.entity.RequestCaptureEntity;
import com.springboot.entity.RequestCapturePrimaryKey;

@Repository
public interface RequestCaptureRepository extends CrudRepository<RequestCaptureEntity, RequestCapturePrimaryKey> {

	@Query("insert into spring_cloud.request (id, last_name, address, age, first_name, major, unique_id, verify_value) values (:id, :last_name, :address, :age, :first_name, :major, :unique_id, :verify_value) if not exists")
	boolean captureIncomingRequest(@Param("id") String Id, @Param("last_name") String last_name,
			@Param("address") AddressEntity address, @Param("age") String age, @Param("first_name") String first_name,
			@Param("major") String major, @Param("unique_id") UUID unique_id,
			@Param("verify_value") String verify_value);

}