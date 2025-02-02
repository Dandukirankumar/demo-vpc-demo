package com.vpc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vpc.demo.entity.JobDescription;


@Repository
public interface JobRepository extends JpaRepository<JobDescription, Long> {

}

