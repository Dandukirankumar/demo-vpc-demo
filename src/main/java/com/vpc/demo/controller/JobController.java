package com.vpc.demo.controller;

import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vpc.demo.model.JobDetails;
import com.vpc.demo.service.JobInterface;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200/")
public class JobController {

    @Autowired
    private JobInterface jobService;

    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    @GetMapping("/get/{jobID}")
    @Operation(summary = "get job")
    public ResponseEntity<Object> getJobDetails(@PathVariable Long jobID) {
        Instant start = Instant.now();
        Object job = jobService.getJobDetails(jobID);
        logger.info("getJobDetails method took {} ms", Duration.between(start, Instant.now()).toMillis());
        return ResponseEntity.ok(job);
    }

    @PostMapping("/job")
    @Operation(summary = "add job")
    public ResponseEntity<Object> createJob(@RequestBody @Valid JobDetails jobDetails) {
        Instant start = Instant.now();
        Object job = jobService.createJob(jobDetails);
        logger.info("createJob method took {} ms", Duration.between(start, Instant.now()).toMillis());
        return ResponseEntity.ok(job);
    }

    @DeleteMapping("/delete/{jobID}")
    @Operation(summary = "delete job")
    public ResponseEntity<String> deleteJob(@PathVariable Long jobID) {
        Instant start = Instant.now();
        String message = jobService.deleteJob(jobID);
        logger.info("deleteJob method took {} ms", Duration.between(start, Instant.now()).toMillis());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/all")
    @Operation(summary = "get all jobs")
    public ResponseEntity<Object> getAllJobs() {
        Instant start = Instant.now();
        Object jobs = jobService.getAllJobs();
        logger.info("getAllJobs method took {} ms", Duration.between(start, Instant.now()).toMillis());
        return ResponseEntity.ok(jobs);
    }

    @PutMapping("/update/{jobID}")
    @Operation(summary = "update job")
    public ResponseEntity<Object> updateJob(@Valid @RequestBody JobDetails jobDetails) {
        Instant start = Instant.now();
        Object job = jobService.updateJob(jobDetails);
        logger.info("updateJob method took {} ms", Duration.between(start, Instant.now()).toMillis());
        return ResponseEntity.ok(job);
    }
}

