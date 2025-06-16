package com.example.sample_cloud.controller;

import com.example.sample_cloud.service.SampleCloudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sample-cloud")
public class SampleCloudController {
    private final SampleCloudService service;

    @GetMapping()
    public String getSampleCloud() {
        return service.getSampleCloud();
    }

    @PostMapping()
    public String postSampleCloud() {
        return service.postSampleCloud();
    }

    @PutMapping()
    public String putSampleCloud() {
        return service.putSampleCloud();
    }

    @DeleteMapping()
    public String deleteSampleCloud() {
        return service.deleteSampleCloud();
    }
}
