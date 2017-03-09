/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.michaelstark.socialmediascanner.repositories;

import com.michaelstark.socialmediascanner.model.SearchJob;
import com.michaelstark.socialmediascanner.model.SearchResultEntry;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Manages access to the saved search results.
 * @author mstark
 */
@Repository
public interface SearchResultEntryRepository extends CrudRepository<SearchResultEntry, Long> {
    List<SearchResultEntry> findBySearchJob(SearchJob job);
    List<SearchResultEntry> findBySearchJob(SearchJob job, Pageable page);
    
    @Query(value="FROM SearchResults sr WHERE sr.search_job_id = ? ORDER BY sr.search_result_entry_id DESC LIMIT 1")
    SearchResultEntry getLastEntryBySearchJobEntry(SearchJob job);
}
