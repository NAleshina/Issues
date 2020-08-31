package repository;

import domain.Issue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();
    private Issue name1 = new Issue(1, 10, false);
    private Issue name2 = new Issue(2, 40, true);
    private Issue name3 = new Issue(3, 15, false);


    @BeforeEach
    void add() {
        List<Issue> allIssue = new ArrayList<>();
        repository.add(name1);
        repository.add(name2);
        repository.add(name3);
    }

    @Test
    void shouldOpenIssue() {
        repository.openIssue(1);
        List<Issue> actual = repository.getOpenIssue();
        List<Issue> expected = List.of(name1, name2);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotExistOpenIssue() {
        repository.openIssue(4);
        List<Issue> actual = repository.getOpenIssue();
        List<Issue> expected = List.of(name2);
        assertEquals(expected, actual);
    }


    @Test
    void shouldClosedIssue() {
        repository.closedIssue(2);
        List<Issue> actual = repository.getClosedIssue();
        List<Issue> expected = List.of(name1, name2, name3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotExistClosedIssue() {
        repository.closedIssue(4);
        List<Issue> actual = repository.getClosedIssue();
        List<Issue> expected = List.of(name1, name3);
        assertEquals(expected, actual);
    }

    @Test
    void ShouldGetOpenIssue() {
        List<Issue> actual = repository.getOpenIssue();
        List<Issue> expected = List.of(name2);
        assertEquals(expected, actual);

    }

    @Test
    void ShouldGetClosedIssue() {
        List<Issue> actual = repository.getClosedIssue();
        List<Issue> expected = List.of(name1, name3);
        assertEquals(expected, actual);
    }

}