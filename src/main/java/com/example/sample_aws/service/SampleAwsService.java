package com.example.sample_aws.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SampleAwsService {
    public String getSampleAws() {
        log.info("GET Service called");
        return "GET SAMPLE AWS";
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
