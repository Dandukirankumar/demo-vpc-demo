package com.vpc.demo.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_description")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class JobDescription implements Serializable{
	private final static long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Override
	public String toString() {
		return "JobDescription [jobID=" + jobID + ", title=" + title + ", description=" + description + "]";
	}
	public JobDescription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobDescription(Long jobID, String title, String description) {
		super();
		this.jobID = jobID;
		this.title = title;
		this.description = description;
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
		JobDescription other = (JobDescription) obj;
		return Objects.equals(description, other.description) && Objects.equals(jobID, other.jobID)
				&& Objects.equals(title, other.title);
	}
    
}
