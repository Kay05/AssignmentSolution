package com.kuda.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kuda on 10/14/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource {
    private int id;
    private String user;
    private String start_date;
    private String end_date;
    private double rate;
    private String created;
    private String updated;
    private int project;

    public Resource() {
    }

    public Resource(int id, String user, String start_date, String end_date, double rate, String created, String updated, int project) {
        this.id = id;
        this.user = user;
        this.start_date = start_date;
        this.end_date = end_date;
        this.rate = rate;
        this.created = created;
        this.updated = updated;
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }
}
