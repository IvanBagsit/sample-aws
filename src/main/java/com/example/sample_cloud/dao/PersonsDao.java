package com.example.sample_cloud.dao;

import com.example.sample_cloud.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsDao extends JpaRepository<Persons, Long> {
}
