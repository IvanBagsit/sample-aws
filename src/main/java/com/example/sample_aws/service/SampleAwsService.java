package com.example.sample_aws.service;

import com.example.sample_aws.dao.PersonsDao;
import com.example.sample_aws.model.Persons;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SampleAwsService {
    private final PersonsDao personsDao;

    public String getSampleAws() {
        log.info("GET Service called 123");
        return "GET SAMPLE AWS";
    }

    public List<Persons> getAllPersons() {
        log.info("Fetching all Persons");
        return personsDao.findAll();
    }

    public String postSampleAws() {
        log.info("POST Service called");
        return "POST SAMPLE AWS";
    }

    public String putSampleAws() {
        log.info("PUT Service called");
        return "PUT SAMPLE AWS";
    }

    public String deleteSampleAws() {
        log.info("DELETE Service called");
        return "DELETE SAMPLE AWS";
    }
}
