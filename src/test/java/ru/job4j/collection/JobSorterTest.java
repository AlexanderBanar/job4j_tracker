package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobSorterTest {
    @Test
    public void whenComparatorByNameUpSort() {
        List<Job> jobs = Arrays.asList(
                new Job("Create report", 0),
                new Job("Create instruction", 0)
        );
        Collections.sort(jobs, new JobDescByNameUpSort());
        List<Job> expect = Arrays.asList(
                new Job("Create instruction", 0),
                new Job("Create report", 0)
        );
        assertThat(jobs, is(expect));
    }

    @Test
    public void whenComparatorByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Create instruction", 0),
                new Job("Create report", 0)
        );
        Collections.sort(jobs, new JobDescByName());
        List<Job> expect = Arrays.asList(
                new Job("Create report", 0),
                new Job("Create instruction", 0)
        );
        assertThat(jobs, is(expect));
    }

    @Test
    public void whenComparatorByPriorityUpSort() {
        List<Job> jobs = Arrays.asList(
                new Job("Create instruction", 5),
                new Job("Create report", 1)
        );
        Collections.sort(jobs, new JobDescByPriorityUpSort());
        List<Job> expect = Arrays.asList(
                new Job("Create report", 1),
                new Job("Create instruction", 5)
        );
        assertThat(jobs, is(expect));
    }

    @Test
    public void whenComparatorByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Create instruction", 3),
                new Job("Create report", 89)
        );
        Collections.sort(jobs, new JobDescByPriority());
        List<Job> expect = Arrays.asList(
                new Job("Create report", 89),
                new Job("Create instruction", 3)
        );
        assertThat(jobs, is(expect));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameUpAndPriorityUp() {
        Comparator<Job> cmpNameUpPriorityUp =
                new JobDescByNameUpSort().thenComparing(new JobDescByPriorityUpSort());
        List<Job> jobs = Arrays.asList(
                new Job("Create instruction", 8),
                new Job("Create instruction", 3),
                new Job("Fix bug", 1)
        );
        Collections.sort(jobs, cmpNameUpPriorityUp);
        List<Job> expect = Arrays.asList(
                new Job("Create instruction", 3),
                new Job("Create instruction", 8),
                new Job("Fix bug", 1)
        );
        assertThat(jobs, is(expect));
    }
}