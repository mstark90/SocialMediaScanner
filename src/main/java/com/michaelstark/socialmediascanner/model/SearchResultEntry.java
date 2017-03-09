/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.michaelstark.socialmediascanner.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mstark
 */
@Entity
@Table(name = "SearchResultEntries")
public class SearchResultEntry implements Serializable {
    
    private long searchResultEntryId;
    
    private EntrySource entrySource;
    
    private String postId;

    /**
     * @return the searchResultEntryId
     */
    @Id
    @Column(name = "searchResultEntryId")
    @GeneratedValue
    public long getSearchResultEntryId() {
        return searchResultEntryId;
    }

    /**
     * @param searchResultEntryId the searchResultEntryId to set
     */
    public void setSearchResultEntryId(long searchResultEntryId) {
        this.searchResultEntryId = searchResultEntryId;
    }

    /**
     * @return the entrySource
     */
    @Column(name = "entrySource")
    @Enumerated(EnumType.ORDINAL)
    public EntrySource getEntrySource() {
        return entrySource;
    }

    /**
     * @param entrySource the entrySource to set
     */
    public void setEntrySource(EntrySource entrySource) {
        this.entrySource = entrySource;
    }

    /**
     * @return the postId
     */
    @Column(name = "postId", length = 60)
    public String getPostId() {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }
}
