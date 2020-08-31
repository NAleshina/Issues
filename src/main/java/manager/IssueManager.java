package manager;

import domain.Issue;
import repository.IssueRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class IssueManager {
    private IssueRepository repository;

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public Predicate<Issue> byAssignee(String assignee) {
        return p -> p.getAssignee().contains(assignee);
    }

    public Predicate<Issue> byAuthor(String author) {
        return p -> p.getAuthor().equalsIgnoreCase(author);
    }

    public Predicate<Issue> byLabel(String label) {
        return p -> p.getLabel().equalsIgnoreCase(label);
    }

    public List<Issue> filterIssues(List<Issue> issues, Predicate<Issue> predicate) {
        return issues.stream().filter(predicate).collect(Collectors.<Issue>toList());
    }

    public List<Issue> filterByAuthor(String author) {
        return sortingIssue(filterIssues(repository.findAll(), byAuthor(author)));
    }

    public List<Issue> filterByLabel(String label) {
        return sortingIssue(filterIssues(repository.findAll(), byLabel(label)));
    }

    public List<Issue> filterByAssignee(String assignee) {
        return sortingIssue(filterIssues(repository.findAll(), byAssignee(assignee)));
    }

    public List<Issue> sortingIssue(List<Issue> sorted) {
        Collections.sort(sorted);
        return sorted;
    }
}
