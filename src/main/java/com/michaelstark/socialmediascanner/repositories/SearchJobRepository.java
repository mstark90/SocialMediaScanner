/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.michaelstark.socialmediascanner.repositories;

import com.michaelstark.socialmediascanner.model.SearchJob;
import com.michaelstark.socialmediascanner.model.User;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mstark
 */
@Repository
public interface SearchJobRepository extends CrudRepository<SearchJob, Long> {
    
    @Override
    List<SearchJob> findAll();
    
    List<SearchJob> findByUser(User user);
    
    @Query("SELECT sj FROM SearchJobs sj WHERE sj.startTime <= ?1 AND sj.endTime >= ?1")
    List<SearchJob> findByExecutionTime(Date startTime, Date endTime);
}
