package com.mysearch.entity;

import javax.persistence.*;


@Entity
@Table(name = "search_data")
public class SearchEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "search_string")
    private String searchString;

    @Column(name ="frequency")
    private long frequency;

    public int getId() {
        return id;
    }

    public String getSearchString() {
        return searchString;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public SearchEntity(int id, String searchString, long frequency) {
        this.id = id;
        this.searchString = searchString;
        this.frequency = frequency;
    }

    public SearchEntity() {
    }
}
