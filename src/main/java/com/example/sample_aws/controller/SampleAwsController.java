package com.example.sample_aws.controller;

import com.example.sample_aws.model.Persons;
import com.example.sample_aws.service.SampleAwsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sample-aws")
public class SampleAwsController {
    private final SampleAwsService service;

    @GetMapping("/persons")
    public List<Persons> getAllPersons() {
        return service.getAllPersons();
    }

    @GetMapping()
    public String getSampleAws() {
        return service.getSampleAws();
    }

    @PostMapping()
    public String postSampleAws() {
        return service.postSampleAws();
    }

    @PutMapping()
    public String putSampleAws() {
        return service.putSampleAws();
    }

    @DeleteMapping()
    public String deleteSampleAws() {
        return service.deleteSampleAws();
    }
}
