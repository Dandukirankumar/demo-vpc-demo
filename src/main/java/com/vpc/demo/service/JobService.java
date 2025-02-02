package com.vpc.demo.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vpc.demo.entity.JobDescription;
import com.vpc.demo.model.JobDetails;
import com.vpc.demo.repository.JobRepository;
import com.vpc.demo.utils.GeneralUtils;

@Component
public class JobService implements JobInterface {   

    @Autowired
    private JobRepository jobRepository;
    

    @Override
    public Object getJobDetails(Long jobIdLong) {
        Optional<JobDescription> jobDescription = jobRepository.findById(jobIdLong);
        if (jobDescription.isPresent()) {
            JobDetails jobDetails = GeneralUtils.convertJobDescriptionToJobDetails(jobDescription.get());
            return jobDetails;
        }
        return "No job found";
    }

    @Override
    public Object createJob(JobDetails jobDetails) {
        JobDescription jobDescription = GeneralUtils.convertJobDetailsToJobDescription(jobDetails);
        jobRepository.save(jobDescription);
        return "Job created successfully";
    }

    @Override
    public String deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
        return "Job deleted successfully";
    }

    @Override
    public Object getAllJobs() {
        List<JobDescription> jobDescriptions = jobRepository.findAll();
        List<JobDetails> jobDetails = jobDescriptions.stream()
            .map(GeneralUtils::convertJobDescriptionToJobDetails)
            .collect(Collectors.toList());
        return jobDetails;
    }

    @Override
    public Object updateJob(JobDetails jobDetails) {
        JobDescription jobDescription = GeneralUtils.convertJobDetailsToJobDescription(jobDetails);
        jobRepository.save(jobDescription);
        return "Job updated successfully";
    }

    
}
