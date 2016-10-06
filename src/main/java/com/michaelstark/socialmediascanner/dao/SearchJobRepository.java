/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.michaelstark.socialmediascanner.dao;

import com.michaelstark.socialmediascanner.entity.SearchJob;
import com.michaelstark.socialmediascanner.entity.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mstark
 */
public interface SearchJobRepository extends CrudRepository<SearchJob, Long> {
    SearchJob getById(long searchJobId);
    
    List<SearchJob> getAllJobs();
    
    List<SearchJob> getByUser(User user);
    
    void create(SearchJob job);
}
