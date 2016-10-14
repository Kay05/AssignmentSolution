package com.kuda.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * Created by kuda on 10/14/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {
    private int id;
    private String title;
    private String due_date;
    private double estimated_hours;
    private int project;
    @Ignore
    private Object project_data;

    public Task() {
    }

    public Task(int id, String title, String due_date, double estimated_hours, int project) {
        this.id = id;
        this.title = title;
        this.due_date = due_date;
        this.estimated_hours = estimated_hours;
        this.project = project;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public double getEstimated_hours() {
        return estimated_hours;
    }

    public void setEstimated_hours(double estimated_hours) {
        this.estimated_hours = estimated_hours;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
