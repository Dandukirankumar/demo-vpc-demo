package com.vpc.demo.utils;

import org.springframework.stereotype.Component;

import com.vpc.demo.entity.JobDescription;
import com.vpc.demo.model.JobDetails;

@Component
public class GeneralUtils {

    // convert JobDescription to JobDetails
    public static JobDetails convertJobDescriptionToJobDetails(JobDescription jobDescription) {
        JobDetails jobDetails = new JobDetails();
        jobDetails.setJobID(jobDescription.getJobID());
        jobDetails.setTitle(jobDescription.getTitle());
        jobDetails.setDescription(jobDescription.getDescription());
        return jobDetails;
    }

    // convert JobDetails to JobDescription
    public static JobDescription convertJobDetailsToJobDescription(JobDetails jobDetails) {
        JobDescription jobDescription = new JobDescription();
        jobDescription.setJobID(jobDetails.getJobID());
        jobDescription.setTitle(jobDetails.getTitle());
        jobDescription.setDescription(jobDetails.getDescription());
        return jobDescription;
    }
}
