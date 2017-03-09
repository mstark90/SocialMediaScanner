/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.michaelstark.socialmediascanner.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author mstark
 */
@Entity
public class JobAnalysis implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    private String id;
    
    private long jobId;
    
    private long wordCount;
    private long postCount;
    
    @OneToMany
    private List<WordEntry> words;
    
    @OneToMany
    private List<PostEntry> posts;

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
     * @return the jobId
     */
    public long getJobId() {
        return jobId;
    }

    /**
     * @param jobId the jobId to set
     */
    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    /**
     * @return the wordCount
     */
    public long getWordCount() {
        return wordCount;
    }

    /**
     * @param wordCount the wordCount to set
     */
    public void setWordCount(long wordCount) {
        this.wordCount = wordCount;
    }

    /**
     * @return the postCount
     */
    public long getPostCount() {
        return postCount;
    }

    /**
     * @param postCount the postCount to set
     */
    public void setPostCount(long postCount) {
        this.postCount = postCount;
    }

    /**
     * @return the words
     */
    public List<WordEntry> getWords() {
        return words;
    }

    /**
     * @param words the words to set
     */
    public void setWords(List<WordEntry> words) {
        this.words = words;
    }

    /**
     * @return the posts
     */
    public List<PostEntry> getPosts() {
        return posts;
    }

    /**
     * @param posts the posts to set
     */
    public void setPosts(List<PostEntry> posts) {
        this.posts = posts;
    }
}
