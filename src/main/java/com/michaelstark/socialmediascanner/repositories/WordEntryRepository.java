/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.michaelstark.socialmediascanner.repositories;

import com.michaelstark.socialmediascanner.model.WordEntry;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author mstark
 */
public interface WordEntryRepository extends MongoRepository<WordEntry, String> {
    List<WordEntry> findByJobAnalysisIdIn(List<String> jobAnalysisIdList);
    List<WordEntry> findByJobAnalysisId(String jobAnalysisId);
}
