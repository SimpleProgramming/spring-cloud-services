package com.springboot.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.AuditLog;

@Repository
public interface AuditLogRepository extends CrudRepository<AuditLog, Serializable> {

}