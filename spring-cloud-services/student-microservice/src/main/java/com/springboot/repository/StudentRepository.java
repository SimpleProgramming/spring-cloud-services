package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.StudentEntity;
import com.springboot.entity.StudentPrimaryKey;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, StudentPrimaryKey> {
}