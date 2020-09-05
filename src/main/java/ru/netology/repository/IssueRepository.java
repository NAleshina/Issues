package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;


public class IssueRepository {
    private List<Issue> items = new ArrayList<>();

    public boolean add(Issue item) {
        return items.add(item);
    }

    public List<Issue> findAll() {
        return items;
    }

    public void openIssue(int id) {
        List<Issue> allIssue = findAll();
        for (int i = 0; i < allIssue.size(); i++) {
            if (allIssue.get(i).getId() == id) {
                allIssue.get(i).setOpen(true);
                break;
            }
        }
    }

    public void closedIssue(int id) {
        List<Issue> allIssue = findAll();
        for (int i = 0; i < allIssue.size(); i++) {
            if (allIssue.get(i).getId() == id) {
                allIssue.get(i).setOpen(false);
                break;
            }
        }
    }

    public List<Issue> getOpenIssue() {
        List<Issue> openIssue = new ArrayList<>();
        for (Issue issue : findAll()) {
            if (issue.isOpen()) {
                openIssue.add(issue);
            }
        }
        return openIssue;
    }

    public List<Issue> getClosedIssue() {
        List<Issue> closedIssue = new ArrayList<>();
        for (Issue issue : findAll()) {
            if (!issue.isOpen()) {
                closedIssue.add(issue);
            }
        }
        return closedIssue;
    }
}
