package com.example.sample_cloud.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SampleCloudService {

    public String getSampleCloud() {
        log.info("GET Service called");
        return "GET SAMPLE CLOUD UPDATED";
    }

    public String postSampleCloud() {
        log.info("POST Service called");
        return "POST SAMPLE CLOUD UPDATED";
    }

    public String putSampleCloud() {
        log.info("PUT Service called");
        return "PUT SAMPLE CLOUD UPDATED";
    }

    public String deleteSampleCloud() {
        log.info("DELETE Service called");
        return "DELETE SAMPLE CLOUD UPDATED";
    }
}
