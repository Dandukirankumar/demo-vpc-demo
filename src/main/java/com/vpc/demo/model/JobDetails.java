package com.vpc.demo.model;


import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class JobDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long jobID;
    private String title;
    private String description;
	public Long getJobID() {
		return jobID;
	}
	public void setJobID(Long jobID) {
		this.jobID = jobID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public JobDetails(Long jobID, String title, String description) {
		super();
		this.jobID = jobID;
		this.title = title;
		this.description = description;
	}
	public JobDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JobDetails [jobID=" + jobID + ", title=" + title + ", description=" + description + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, jobID, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobDetails other = (JobDetails) obj;
		return Objects.equals(description, other.description) && Objects.equals(jobID, other.jobID)
				&& Objects.equals(title, other.title);
	}
    
    
}

