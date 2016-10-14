package com.kuda.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by kuda on 10/14/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    private int pk;
    private String title;
    private String description;
    private String start_date;
    private String end_date;
    private boolean is_billable;
    private boolean is_active;
    private ArrayList<Task> task_set;
    private ArrayList<Resource> resource_set;

    public Project() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getResource_set() {
        return resource_set.clone();
    }

    public void setResources_set(ArrayList<Resource> resources_set) {
        this.resource_set = resources_set;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart_date() {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date j = df.parse(start_date);
            String date = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH).format(j);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return start_date;
        }
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date j = df.parse(end_date);
            String date = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(j);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return end_date;
        }
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public boolean isIs_billable() {
        return is_billable;
    }

    public void setIs_billable(boolean is_billable) {
        this.is_billable = is_billable;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Object getTask_set() {
        return task_set.clone();
    }

    public void setTask_set(ArrayList<Task> task_set) {
        this.task_set = task_set;
    }
}
