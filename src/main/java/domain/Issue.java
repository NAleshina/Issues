package domain;

import java.util.Set;

public class Issue implements Comparable<Issue> {
    private int id;
    private String name;
    private Set<String> assignee;
    private int timeCreation;
    private String label;
    private boolean open;
    private String author;

    public Issue(Set<String> assignee, String label, String author, int timeCreation) {
        this.assignee = assignee;
        this.label = label;
        this.author = author;
        this.timeCreation = timeCreation;
    }

    public Issue() {
    }

    public Issue(int id, int timeCreation, boolean open) {
        this.id = id;
        this.timeCreation = timeCreation;
        this.open = open;
    }

    public int compareTo(Issue o) {
        return timeCreation - o.timeCreation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getAssignee() {
        return assignee;
    }

    public int getTimeCreation() {
        return timeCreation;
    }

    public String getLabel() {
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
