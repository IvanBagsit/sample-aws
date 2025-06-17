package com.example.sample_cloud.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SampleCloudService {

    @Value("${custom.string.message}")
    private String message;

    public String getSampleCloud() {
        log.info("GET Service called");
        return String.format("GET SAMPLE | ENV custom.string.message: %s", message);
    }

    public String postSampleCloud() {
        log.info("POST Service called");
        return "POST SAMPLE";
    }

    public String putSampleCloud() {
        log.info("PUT Service called");
        return "PUT SAMPLE";
    }

    public String deleteSampleCloud() {
        log.info("DELETE Service called");
        return "DELETE SAMPLE";
    }
}
