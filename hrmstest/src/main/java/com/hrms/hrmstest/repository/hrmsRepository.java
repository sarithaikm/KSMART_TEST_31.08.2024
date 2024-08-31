package com.hrms.hrmstest.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.hrmstest.model.hrmsModel;


@Repository
public interface hrmsRepository extends JpaRepository<hrmsModel, UUID> {
}
//public interface hrmsRepository extends JpaRepository<hrmsModel, Integer> {
