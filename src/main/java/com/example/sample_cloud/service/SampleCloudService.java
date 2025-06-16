package com.example.sample_cloud.service;

import com.example.sample_cloud.dao.PersonsDao;
import com.example.sample_cloud.model.Persons;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SampleCloudService {
    private final PersonsDao personsDao;

    public String getSampleCloud() {
        log.info("GET Service called");
        return "GET SAMPLE CLOUD";
    }

    public List<Persons> getAllPersons() {
        log.info("Fetching all Persons");
        return personsDao.findAll();
    }

    public String postSampleCloud() {
        log.info("POST Service called");
        return "POST SAMPLE CLOUD";
    }

    public String putSampleCloud() {
        log.info("PUT Service called");
        return "PUT SAMPLE CLOUD";
    }

    public String deleteSampleCloud() {
        log.info("DELETE Service called");
        return "DELETE SAMPLE CLOUD";
    }
}
