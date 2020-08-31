package manager;

import domain.Issue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.IssueRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
class IssueManagerTest {
    @Mock
    private IssueRepository repository;
    @InjectMocks
    private IssueManager manager;

    private Issue name1 = new Issue(Set.of("one", "two"), "bag", "first", 77);
    private Issue name2 = new Issue(Set.of("two"), "task", "second", 123);
    private Issue name3 = new Issue(Set.of("three"), "bag", "first", 135);

    @BeforeEach
    void add() {
        List<Issue> returned = new ArrayList<>();
        returned.add(name1);
        returned.add(name2);
        returned.add(name3);
        doReturn(returned).when(repository).findAll();

    }

    @Test
    void shouldFilterByAuthor() {
        List<Issue> actual = manager.filterByAuthor("first");
        List<Issue> expected = List.of(name1, name3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFilterByLabel() {
        List<Issue> actual = manager.filterByLabel("bag");
        List<Issue> expected = List.of(name1, name3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFilterByAssignee() {
        List<Issue> actual = manager.filterByAssignee("two");
        List<Issue> expected = List.of(name1, name2);
        assertEquals(expected, actual);
    }
}