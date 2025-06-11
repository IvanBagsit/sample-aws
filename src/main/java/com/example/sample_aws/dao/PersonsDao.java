package com.example.sample_aws.dao;

import com.example.sample_aws.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsDao extends JpaRepository<Persons, Long> {
}
