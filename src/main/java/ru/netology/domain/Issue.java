package ru.netology.domain;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

public class Issue implements Comparable<Issue> {
    private int id;
    private Set<String> assignee;
    private Date timeCreation;
    private Set<String> label;
    private boolean open;
    private String author;

    public Issue(Set<String> assignee, Set<String> label, String author, Date timeCreation) {
        this.assignee = assignee;
        this.label = label;
        this.author = author;
        this.timeCreation = timeCreation;
    }

    public Issue() {
    }

    public Issue(int id, Date timeCreation, boolean open) {
        this.id = id;
        this.timeCreation = timeCreation;
        this.open = open;
    }

    public int compareTo(Issue o) {
        return o.timeCreation.compareTo(timeCreation);
    }

    public int getId() {
        return id;
    }

    public Set<String> getAssignee() {
        return assignee;
    }

    public Date getTimeCreation() {
        return timeCreation;
    }

    public Set<String> getLabel() {
        return label;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen() {
        return open;
    }

    public String getAuthor() {
        return author;
    }
}
