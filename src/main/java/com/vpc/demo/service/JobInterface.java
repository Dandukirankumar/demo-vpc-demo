/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.vpc.demo.service;

import org.springframework.stereotype.Service;

import com.vpc.demo.model.JobDetails;
@Service
public interface JobInterface {
    Object getJobDetails(Long customerId);
    Object createJob(JobDetails jobDetails); 
    String deleteJob(Long customerId);
    Object getAllJobs();
    Object updateJob(JobDetails jobDetails);

}
