package ru.netology.repository;

import ru.netology.domain.Issue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.IssueRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private Issue name1 = new Issue(1, sdf.parse("2020-09-05"), false);
    private Issue name2 = new Issue(2, sdf.parse("2020-09-06"), true);
    private Issue name3 = new Issue(3, sdf.parse("2020-09-03"), false);

    IssueRepositoryTest() throws ParseException {
    }


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