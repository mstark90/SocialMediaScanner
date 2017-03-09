/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.michaelstark.socialmediascanner.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mstark
 */
@Entity
@Table(name = "SearchJobs")
public class SearchJob implements Serializable {
    
    private long searchJobId;
    
    private User originator;

    private String jobName;
    
    private Date startTime = new Date();
    
    private Date endTime = new Date();
    
    private List<String> searchQueries;
    
    private List<SearchResultEntry> resultEntries;
    
    private boolean running;

    /**
     * @return the searchJobId
     */
    @Id
    @Column(name = "searchJobId")
    @GeneratedValue
    public long getSearchJobId() {
        return searchJobId;
    }

    /**
     * @param searchJobId the searchJobId to set
     */
    public void setSearchJobId(long searchJobId) {
        this.searchJobId = searchJobId;
    }

    /**
     * @return the originator
     */
    @ManyToOne
    @JoinColumn(name = "userId")
    public User getOriginator() {
        return originator;
    }

    /**
     * @param originator the originator to set
     */
    public void setOriginator(User originator) {
        this.originator = originator;
    }

    /**
     * @return the jobName
     */
    @Column(name = "jobName", length = 60)
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName the jobName to set
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * @return the startTime
     */
    @Column(name = "startTime")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    @Column(name = "endTime")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the searchQueries
     */
    @ElementCollection
    @CollectionTable(name = "SearchQueries", joinColumns = @JoinColumn(name = "searchJobId"))
    @Column(name = "searchQuery")
    public List<String> getSearchQueries() {
        return searchQueries;
    }

    /**
     * @param searchQueries the searchQueries to set
     */
    public void setSearchQueries(List<String> searchQueries) {
        this.searchQueries = searchQueries;
    }

    /**
     * @return the resultEntries
     */
    @ElementCollection
    @CollectionTable(name = "SearchResultEntries", joinColumns = @JoinColumn(name = "searchJobId"))
    @OneToMany
    public List<SearchResultEntry> getResultEntries() {
        return resultEntries;
    }

    /**
     * @param resultEntries the resultEntries to set
     */
    public void setResultEntries(List<SearchResultEntry> resultEntries) {
        this.resultEntries = resultEntries;
    }

    /**
     * Returns true if the job is currently running, false if otherwise.
     * @return True if the job is currently running, false if otherwise.
     */
    @Column(name = "running")
    public boolean isRunning() {
        return running;
    }

    /**
     * Sets a value to check to see if the job is running.
     * @param running True if the job is running, false if otherwise.
     */
    public void setRunning(boolean running) {
        this.running = running;
    }
}
