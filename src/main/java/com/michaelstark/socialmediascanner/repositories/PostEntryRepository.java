/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.michaelstark.socialmediascanner.repositories;

import com.michaelstark.socialmediascanner.model.PostEntry;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author mstark
 */
public interface PostEntryRepository extends MongoRepository<PostEntry, String> {
    List<PostEntry> findByJobAnalysisId(String jobAnalysisId);
    List<PostEntry> findByJobAnalysisIdIn(List<String> jobAnalysisIds);
}
