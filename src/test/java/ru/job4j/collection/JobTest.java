package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Z task", 0),
                new Job("AFix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameLn() {
        Comparator<Job> cmpName = new JobDescByNameLn();
        int rsl = cmpName.compare(
                new Job("AFix bug", 0),
                new Job("Z bugs", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByPrority() {
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(
                new Job("Z task", 4),
                new Job("AFix bug", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByProrityLn() {
        Comparator<Job> cmpName = new JobDescByPriorityLn();
        int rsl = cmpName.compare(
                new Job("AFix bug", 1),
                new Job("Z bugs", 3)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameLnAndProrityLn() {
        Comparator<Job> cmpNamePriority = new JobDescByNameLn().thenComparing(new JobDescByPriorityLn());
        int rsl = cmpNamePriority.compare(
                new Job("task", 0),
                new Job("task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameLnAndProrityLn1() {
        Comparator<Job> cmpNamePriority = new JobDescByNameLn().thenComparing(new JobDescByPriorityLn());
        int rsl = cmpNamePriority.compare(
                new Job("Ask", 4),
                new Job("Ask", 3)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}