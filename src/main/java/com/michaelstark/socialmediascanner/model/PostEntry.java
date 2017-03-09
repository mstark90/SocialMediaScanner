/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.michaelstark.socialmediascanner.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author mstark
 */
@Entity
public class PostEntry implements Serializable {
    @Id
    private String id;
    
    private String jobAnalysisId;
    
    private String text;
    private String poster;

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the poster
     */
    public String getPoster() {
        return poster;
    }

    /**
     * @param poster the poster to set
     */
    public void setPoster(String poster) {
        this.poster = poster;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the jobAnalysisId
     */
    public String getJobAnalysisId() {
        return jobAnalysisId;
    }

    /**
     * @param jobAnalysisId the jobAnalysisId to set
     */
    public void setJobAnalysisId(String jobAnalysisId) {
        this.jobAnalysisId = jobAnalysisId;
    }
}
