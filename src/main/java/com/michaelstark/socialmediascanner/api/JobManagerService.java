/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.michaelstark.socialmediascanner.api;

import com.michaelstark.socialmediascanner.repositories.SearchJobRepository;
import com.michaelstark.socialmediascanner.repositories.SearchResultEntryRepository;
import com.michaelstark.socialmediascanner.model.SearchJob;
import com.michaelstark.socialmediascanner.model.SearchResultEntry;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author mstark
 */
@Component
public class JobManagerService {
    @Autowired
    private SearchJobRepository jobs;
    
    @Autowired
    private SearchResultEntryRepository resultEntries;
    
    @Scheduled(cron="*/5 * * * *")
    public void updateJobs() {
        Date date = Calendar.getInstance().getTime();
        
        for(SearchJob job : jobs.findAll()) {
            if(job.getStartTime().compareTo(date) <= 0 && job.getEndTime().compareTo(date) > 0 
                    && job.isRunning() == false) {
                executeJob(job);
            }
        }
    }
    
    @Async
    public void executeJob(SearchJob job) {
        job.setRunning(true);
        jobs.save(job);
        
        SearchResultEntry lastEntry = resultEntries.getLastEntryBySearchJobEntry(job);
        
        
        
        job.setRunning(false);
        jobs.save(job);
    }
}
